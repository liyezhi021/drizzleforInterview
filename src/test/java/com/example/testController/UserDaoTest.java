package com.example.testController;

import com.example.DemoApplication;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//TestDaoOK
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class UserDaoTest {
    @Autowired
    private UserMapper userMapper;


    @Test
    public void Testlogin(){
        String username = "payne";
        String password = "payne123";
        User user = userMapper.loginUser(username,password);
        System.out.println("user="+user);
    }

}
