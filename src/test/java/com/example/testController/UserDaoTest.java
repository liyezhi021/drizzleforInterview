package com.example.testController;

import com.example.Application;
import com.example.entity.User;
import com.example.mapper.majorDs.UserMapper;
import com.example.miniMybatis.Insert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Method;

//TestDaoOK
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserDaoTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void Testlogin() {
        String username = "payne";
        String password = "payne123";
        User user = userMapper.loginUser(username, password);
        System.out.println("user=" + user);
    }

    @Test
    public void InsertTest(){
        Object[] parameters = {"li", "123456"};
        Method[] methods = com.example.miniMybatis.UserMapper.class.getDeclaredMethods();
        String sql;
        for(Method method: methods){
            if(method.isAnnotationPresent(Insert.class)){
                //check sql is ok!
                sql = method.getAnnotation(Insert.class).value();
                try {
                    jdbcTemplate.update(sql, parameters);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

}
