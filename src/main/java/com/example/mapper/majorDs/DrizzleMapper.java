package com.example.mapper.majorDs;

import com.example.entity.Drizzle;

public interface DrizzleMapper {
    int deleteByPrimaryKey(Integer iddrizzle);

    int insert(Drizzle record);

    int insertSelective(Drizzle record);

    Drizzle selectByPrimaryKey(Integer iddrizzle);

    int updateByPrimaryKeySelective(Drizzle record);

    int updateByPrimaryKey(Drizzle record);
}