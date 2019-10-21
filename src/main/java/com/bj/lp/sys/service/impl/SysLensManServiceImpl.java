package com.bj.lp.sys.service.impl;

import com.bj.lp.common.exception.ServiceException;
import com.bj.lp.sys.dao.SysLensManDao;
import com.bj.lp.sys.entity.SysLensMan;
import com.bj.lp.sys.service.SysLensManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SysLensManServiceImpl implements SysLensManService {
    @Autowired
   private SysLensManDao sysLensManDao;
     @Override
    public int saveLensMan(SysLensMan entity) {
        //合法验证
        if(entity==null)throw  new ServiceException("未添加摄影师信息");
        if(StringUtils.isEmpty(entity.getMname()))
            throw  new ServiceException("摄影师称呼不能为空");
        if(StringUtils.isEmpty(entity.getMjob()))
            throw  new ServiceException("请给摄影师设置职位");
        //保存数据
        int rows= sysLensManDao.saveLensMan(entity);
        return  rows;


    }
}
