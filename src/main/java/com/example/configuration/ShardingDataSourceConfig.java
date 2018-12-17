package com.example.configuration;

import com.dangdang.ddframe.rdb.sharding.api.ShardingDataSourceFactory;
import com.dangdang.ddframe.rdb.sharding.api.rule.DataSourceRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.TableRule;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.DatabaseShardingStrategy;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.TableShardingStrategy;
import com.dangdang.ddframe.rdb.sharding.id.generator.self.CommonSelfIdGenerator;
import com.dangdang.ddframe.rdb.sharding.id.generator.self.time.AbstractClock;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;

@Configuration
@MapperScan(basePackages = {"com.example.mapper.shardingDs"},
        sqlSessionFactoryRef = "sessionFactory")
public class ShardingDataSourceConfig {

    @Bean
    @Autowired
    public HashMap<String, DataSource> dataSourceMap(@Qualifier(value = "majorDataSource") DataSource dataSource_sh , @Qualifier(value = "minorDataSource")DataSource dataSource_sz) {
        HashMap<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("db_sh",dataSource_sh);
        dataSourceMap.put("db_sz",dataSource_sz);
        return dataSourceMap;
    }

    @Bean
    public DataSource shardingDataSource(HashMap<String, DataSource> dataSourceMap, DatabaseShardingStrategy databaseShardingStrategy, TableShardingStrategy tableShardingStrategy) {
        DataSourceRule dataSourceRule = new DataSourceRule(dataSourceMap);
        TableRule tableRule = TableRule.builder("tick").actualTables(Arrays.asList("db_sh.tick_a_2018_11", "db_sh.tick_a_2018_12", "db_sh.tick_b_2018_11", "db_sh.tick_b_2018_12", "db_sz.tick_a_2018_11", "db_sz.tick_a_2018_12", "db_sz.tick_b_2018_11", "db_sz.tick_a_2018_12")).dataSourceRule(dataSourceRule).build();
        ShardingRule shardingRule = ShardingRule.builder().dataSourceRule(dataSourceRule).tableRules(Arrays.asList(tableRule)).databaseShardingStrategy(databaseShardingStrategy).tableShardingStrategy(tableShardingStrategy).build();
        DataSource shardingDataSource = ShardingDataSourceFactory.createDataSource(shardingRule);
        return shardingDataSource;
    }

    @Bean
    public SqlSessionFactory sessionFactory(@Qualifier(value = "shardingDataSource") DataSource shardingDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(shardingDataSource);
        return sessionFactory.getObject();
    }

    @Bean
    public CommonSelfIdGenerator commonSelfIdGenerator() {
        CommonSelfIdGenerator.setClock(AbstractClock.systemClock());
        CommonSelfIdGenerator commonSelfIdGenerator = new CommonSelfIdGenerator();
        return commonSelfIdGenerator;
    }

}
