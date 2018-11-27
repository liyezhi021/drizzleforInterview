package com.example.TestSharding;

import com.dangdang.ddframe.rdb.sharding.id.generator.self.CommonSelfIdGenerator;
import com.example.entity.Tick;
import com.example.mapper.shardingDs.TickMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestSharding {

    @Autowired
    private TickMapper tickMapper;

    @Autowired
    private CommonSelfIdGenerator commonSelfIdGenerator;


    @Test
    public void contextLoads() {
        Tick tick = new Tick(commonSelfIdGenerator.generateId().longValue(), "a", "sh", 100, 200, new Date());
        this.tickMapper.insertTick(tick);
    }
}
