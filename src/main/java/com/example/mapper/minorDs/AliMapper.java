package com.example.mapper.minorDs;

import com.example.entity.Ali;

public interface AliMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ali record);

    int insertSelective(Ali record);

    Ali selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ali record);

    int updateByPrimaryKey(Ali record);
}