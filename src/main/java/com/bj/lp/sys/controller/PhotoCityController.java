package com.bj.lp.sys.controller;

import com.bj.lp.common.vo.JsonResult;
import com.bj.lp.sys.entity.PhotoCity;
import com.bj.lp.sys.service.impl.PhotoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/log/")
public class PhotoCityController {
    @Autowired
    private PhotoServiceImpl.PhotoCityService photoCityService;
    @RequestMapping("getPhotos")
    @ResponseBody
    public JsonResult getPhotos(Integer id){
        System.out.println("客户端传过来的id是什么--------"+id);
        List<PhotoCity> cityObject = photoCityService.getCityObject(id);
        System.out.println(cityObject);
        return new JsonResult(cityObject);
    }
}
