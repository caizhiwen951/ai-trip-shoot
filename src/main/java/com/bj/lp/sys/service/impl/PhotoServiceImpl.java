package com.bj.lp.sys.service.impl;

import com.bj.lp.common.exception.ServiceException;
import com.bj.lp.sys.dao.PhotoCityDao;
import com.bj.lp.sys.entity.PhotoCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoServiceImpl.PhotoCityService {
    @Autowired
    private PhotoCityDao photoCityDao;
    @Override
    public List<PhotoCity> getCityObject(Integer id) {
        if (id==null)
            throw new IllegalArgumentException("前先选中");
        int cityId = photoCityDao.getCityId(id);
        System.out.println("服务层的..这是个什么东西----------"+cityId);

        List<PhotoCity> imgUrl = photoCityDao.getTheSignPath(cityId);
        if (imgUrl==null )
            throw new ServiceException("该城市暂时还没有拍摄图片...");


        return imgUrl;
    }

    public static interface PhotoCityService {
        List<PhotoCity> getCityObject(Integer id);

    }
}
