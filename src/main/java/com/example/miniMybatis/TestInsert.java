package com.example.miniMybatis;

import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.Method;

public class TestInsert {

    //https://www.jianshu.com/p/bbbc9f4c7887
    private static JdbcTemplate jdbcTemplate;

    public static void main(String[] args){
        Object[] parameters = {"li", "123456"};
        Method[] methods = UserMapper.class.getDeclaredMethods();
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
