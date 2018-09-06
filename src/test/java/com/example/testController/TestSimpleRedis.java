package com.example.testController;

import com.example.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestSimpleRedis {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test1() throws Exception{
        //save string
        stringRedisTemplate.opsForValue().set("payne","payneredis");
        Assert.assertEquals("payneredis",stringRedisTemplate.opsForValue().get("payne"));
    }

}
