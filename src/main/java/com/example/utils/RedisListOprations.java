package com.example.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class RedisListOprations {

    @Autowired
    private ListOperations<String, Object> listOperations;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * @description 简单的往数组里面添加元素
     * @param key
     * @param value
     */
    public void lPush(String key, String value){
        int backValue = listOperations.leftPush(key, value).intValue();
        System.out.println("返回值"+ backValue);
    }

    /**
     * @description 批量往数组里面添加元素
     * @param key
     * @param list
     */
    public void lPushAll(String key, List<String> list)
    {
        int backValue = listOperations.leftPushAll(key, list).intValue();
        System.out.println("返回值 : " + backValue);
    }

    /**
     * @description  对指定下标的数组元素进行替换
     * @param key
     * @param offset
     * @param value
     */
    public void set(String key, int offset, String value)
    {
        listOperations.set(key, offset, value);
    }

    /**
     * @description  对指定下标的数组进行插入数据
     * @param key
     * @param value1    原有值
     * @param value2    插入的值
     */
    public void insert(String key, String value1, String value2)
    {
        int backValue = listOperations.leftPush(key, value1, value2).intValue();
        System.out.println("返回值 : " + backValue);
    }

    /**
     * @description  获取指定下标的数组元素
     * @param key
     * @param offset
     */
    public void getValueByIndex(String key, int offset)
    {
        Object value = listOperations.index(key, offset);
        System.out.println(offset + "位置下的值为 : " + value.toString());
    }

    /**
     * @description  获取数组长度
     * @param key
     */
    public void size(String key)
    {
        int length = listOperations.size(key).intValue();
        System.out.println(key + " 数组长度为 : " + length);
    }

    /**
     * @description 移除数组匹配到的数据元素
     * @param key
     * @param count     负数：从右往左     整数：从左往右
     * @param value  移除的值
     */
    public void remove(String key, long count, String value)
    {
        int backValue = listOperations.remove(key, count, value).intValue();
        System.out.println(key + " 数组长度为 : " + backValue);
    }

    /**
     * @description 保留区间内的元素，区间外的全部删除
     * @param key
     * @param start  区间开始
     * @param end    区间结束
     */
    public void trim(String key, int start, int end)
    {
        listOperations.trim(key, start, end);
    }

    /**
     * @description 从左到右，删除第一个元素
     * @param key
     */
    public void lpop(String key)
    {
        Object value = listOperations.leftPop(key);
        System.err.println("移除的元素 ： " + value.toString());
    }


    /**
     * @description  查询区间范围内的元素
     * @param key
     * @param start
     * @param end
     */
    public <T> List<T> lrange(String key, int start, int end, Class<T> clazz)
    {
        List<Object> list = listOperations.range(key, start, end);
        List<T> result = list.stream().map(t->{
            return BeanMapper.map(t, clazz);
        }).collect(Collectors.toList());
        return result;
    }

    /**
     * @description 两个list之间移元素
     * @param sourceKey        源
     * @param destinationKey  目的地
     */
    public void rightPopAndLeftPush(String sourceKey, String destinationKey)
    {
        Object v = listOperations.rightPopAndLeftPush(sourceKey, destinationKey);
        System.out.println("----------" + v.toString());
    }


}
