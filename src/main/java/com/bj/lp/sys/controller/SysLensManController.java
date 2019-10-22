package com.bj.lp.sys.controller;

import com.bj.lp.common.vo.JsonResult;
import com.bj.lp.sys.entity.SysLensMan;
import com.bj.lp.sys.service.SysLensManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/lensMan")
public class SysLensManController {
    @Autowired
    private SysLensManService sysLensManService;

    @RequestMapping(value = "doSaveLensMan",method = RequestMethod.POST)
    public JsonResult doSaveLensMan(SysLensMan entity){
        sysLensManService.saveLensMan(entity);
        return new JsonResult("save ok");



    }




}
