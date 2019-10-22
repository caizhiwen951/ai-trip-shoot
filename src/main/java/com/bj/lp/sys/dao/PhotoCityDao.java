package com.bj.lp.sys.dao;

import com.bj.lp.sys.entity.PhotoCity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface PhotoCityDao {

    /*基于客户端传过来的id先查出是哪个城市*/
    int getCityId(@Param("id") Integer id);
    /**
     * 基于城市id在查询该城市下面所有的图片Url
     */
    List<PhotoCity> getTheSignPath(Integer cityId);
}
