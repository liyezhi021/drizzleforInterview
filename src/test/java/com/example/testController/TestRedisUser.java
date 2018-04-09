package com.example.testController;

import com.example.DemoApplication;
import com.example.entity.RedisUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = DemoApplication.class)
public class TestRedisUser {

    @Autowired
    private RedisTemplate<String,RedisUser> redisTemplate;

    @Test
    public void test() throws Exception{
        RedisUser redisUser = new RedisUser("超人",20);
        redisTemplate.opsForValue().set(redisUser.getUsername(),redisUser);
        redisUser = new RedisUser("蝙蝠侠",30);
        redisTemplate.opsForValue().set(redisUser.getUsername(),redisUser);
        redisUser = new RedisUser("蜘蛛侠",40);
        redisTemplate.opsForValue().set(redisUser.getUsername(),redisUser);
        Assert.assertEquals(20,redisTemplate.opsForValue().get("超人").getAge().longValue());
        Assert.assertEquals(30, redisTemplate.opsForValue().get("蝙蝠侠").getAge().longValue());
        Assert.assertEquals(40, redisTemplate.opsForValue().get("蜘蛛侠").getAge().longValue());
    }

}
