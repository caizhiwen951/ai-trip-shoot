package com.bj.lp.sys.controller;

import com.bj.lp.common.vo.JsonResult;
import com.bj.lp.sys.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class RegisterController {
    /**------------------------------------------注册---------------------------------------------*/
    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = "doRegister", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult doRegister(String RegisterUsername, String RegisterPassword, String RegisterTel, String okok) {
        registerService.doRegister(RegisterUsername, RegisterPassword, RegisterTel,okok);
        return new JsonResult("localhost/");
    }

}