package com.example.mapper.shardingDs;

import com.example.entity.Tick;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface TickMapper {

    @Insert("insert into tick (id,name,exchange,ask,bid,time) values (#{id},#{name},#{exchange},#{ask},#{bid},#{time})")
    void insertTick(Tick tick);


    @SelectProvider(type = TickProvider.class , method = "listTickByCondition")
    List<Tick> listTickByCondition(@Param(value = "name")String name , @Param(value = "exchange") String exchange , @Param(value = "startDate") Date startDate, @Param(value = "endDate")Date endDate);

    @Select("select t.id , t.`name` , t.exchange , t.ask , t.bid , t.time from tick as t")
    List<Tick> listTickAll();

    @SelectProvider(type = TickProvider.class , method = "listTickForPage")
    List<Tick> listTickForPage(@Param(value = "name")String name , @Param(value = "exchange") String exchange , @Param(value = "startDate") Date startDate,@Param(value = "endDate")Date endDate,@Param(value = "startPage") Integer startPage, @Param(value = "pageSize") Integer pageSize);




}

