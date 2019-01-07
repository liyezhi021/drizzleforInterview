package com.example.multiThreading.redisLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("redisLock")
public class RedisLockTest {

    //每个线程保存自己的token
    private static ThreadLocal<String> tokenMap = new ThreadLocal<>();
    String token = tokenMap.get();
    String key = "book";

    @Autowired
    private RedisTemplate redisTemplate;

    public String lock(final String lock){
        String token = tokenMap.get();
        if(StringUtils.isEmpty(token)){
            token = UUID.randomUUID().toString();
            tokenMap.set(token);
        }
        Boolean ret = redisTemplate.opsForValue().setIfAbsent(lock, token);
        if(ret!=null && ret){
            redisTemplate.expire(lock, 4, TimeUnit.SECONDS);
            return Thread.currentThread().getName()+ "-拿到锁";
        }
        return Thread.currentThread().getName()+ "-没有拿到锁";
    }

    @GetMapping("test")
    public void x(){

        for(int i=0; i<3; i++){
            new Thread(new Task()).start();
        }

    }

    public class Task implements Runnable{

        @Override
        public void run() {
            System.out.println(lock("xixi"));
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
