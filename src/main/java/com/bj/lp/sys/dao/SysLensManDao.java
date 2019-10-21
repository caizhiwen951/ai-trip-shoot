package com.bj.lp.sys.dao;

import com.bj.lp.sys.entity.SysLensMan;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysLensManDao {
    int saveLensMan(SysLensMan entity);




}
