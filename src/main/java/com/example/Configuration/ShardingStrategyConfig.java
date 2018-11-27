package com.example.Configuration;

import com.dangdang.ddframe.rdb.sharding.api.strategy.database.DatabaseShardingStrategy;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.TableShardingStrategy;
import com.example.ShardingJdbc.DatabaseShardingAlgorithm;
import com.example.ShardingJdbc.TableShardingAlgorithm;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.LinkedList;


@Configuration
public class ShardingStrategyConfig {

    @Bean
    public DatabaseShardingStrategy databaseShardingStrategy(DatabaseShardingAlgorithm databaseShardingAlgorithm) {
        DatabaseShardingStrategy databaseShardingStrategy = new DatabaseShardingStrategy("exchange", databaseShardingAlgorithm);
        return databaseShardingStrategy;
    }

    @Bean
    public TableShardingStrategy tableShardingStrategy(TableShardingAlgorithm tableShardingAlgorithm) {
        Collection<String> columns = new LinkedList<>();
        columns.add("name");
        columns.add("time");
        TableShardingStrategy tableShardingStrategy = new TableShardingStrategy(columns, tableShardingAlgorithm);
        return tableShardingStrategy;
    }
}
