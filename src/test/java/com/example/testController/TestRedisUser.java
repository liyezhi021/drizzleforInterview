package com.example.testController;

import com.example.Application;
import com.example.entity.UserVo;
import com.example.redis.RedisKeyUtil;
import com.example.redis.RedisService;
import com.example.utils.RedisListOprations;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
public class TestRedisUser {


    @Autowired
    private RedisTemplate redisTemplate;

    @Resource
    private ValueOperations<String,Object> valueOperations;

    @Autowired
    private HashOperations<String, String, Object> hashOperations;

    @Autowired
    private ListOperations<String, Object> listOperations;

    @Autowired
    private SetOperations<String, Object> setOperations;

    @Autowired
    private ZSetOperations<String, Object> zSetOperations;

    @Autowired
    private RedisListOprations redisListOprations;

    @Resource
    private RedisService redisService;

    @Test
    public void testObj() throws Exception{
        UserVo userVo = new UserVo();
        userVo.setAddress("上海");
        userVo.setName("mingLi");
        userVo.setAge(123);
        valueOperations.set("t_user:name:mingLi:",userVo);
        ValueOperations<String,Object> operations = redisTemplate.opsForValue();
        redisService.expireKey("name",20, TimeUnit.MINUTES);
        String key = RedisKeyUtil.getKey(UserVo.Table,"name",userVo.getName());
        UserVo vo = (UserVo) operations.get(key);
        System.out.println(vo);
    }

    @Test
    public void testValueOption( )throws  Exception{
        UserVo userVo = new UserVo();
        userVo.setAddress("上海");
        userVo.setName("jantent");
        userVo.setAge(23);
        valueOperations.set("test",userVo);

        System.out.println(valueOperations.get("test"));
    }

    @Test
    public void testSetOperation() throws Exception{
        UserVo userVo = new UserVo();
        userVo.setAddress("北京");
        userVo.setName("jantent");
        userVo.setAge(23);
        UserVo auserVo = new UserVo();
        auserVo.setAddress("n柜昂周");
        auserVo.setName("antent");
        auserVo.setAge(23);
        setOperations.add("set:test",userVo,auserVo);
        Set<Object> result = setOperations.members("set:test");
        System.out.println(result);
    }

    @Test
    public void HashOperations() throws Exception{
        UserVo userVo = new UserVo();
        userVo.setAddress("北京");
        userVo.setName("jantent");
        userVo.setAge(23);
        hashOperations.put("hash:user",userVo.hashCode()+"",userVo);
        System.out.println(hashOperations.get("hash:user",userVo.hashCode()+""));
    }

    @Test
    public void  ListOperations() throws Exception{
        UserVo userVo = new UserVo();
        userVo.setAddress("北京");
        userVo.setName("jantent");
        userVo.setAge(23);
        UserVo userVo1 = new UserVo();
        userVo1.setAddress("广州");
        userVo1.setName("jan2tent");
        userVo1.setAge(24);
        //listOperations.leftPushAll("list:user",userVo, userVo1);
//      System.out.println(listOperations.leftPop("list:user"));
        // pop之后 值会消失
        //System.out.println(listOperations.leftPop("list:user"));
        List<UserVo> list = redisListOprations.lrange("list:user", 0, 10, UserVo.class);
        System.out.println("size..."+list.size());
        for(Object o : list){
            System.out.println(o);
        }
    }

}
