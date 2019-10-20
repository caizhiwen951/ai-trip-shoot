package com.bj.lp.sys.controller;

import com.bj.lp.common.vo.JsonResult;
import com.bj.lp.sys.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class phoneNumberController {

    @Autowired
    private PhoneNumberService phoneNumberService;
    /**
     * 忘记密码时 对手机号验证前的查询数据库是否存在此手机号用户
     */
    @RequestMapping("findNumber")
    @ResponseBody
    public JsonResult findNumber(String RegisterTel) {
        phoneNumberService.findNumber(RegisterTel);
        return new JsonResult();
    }
    /**
     * -----------------------------手机验证控制层--------------------------------------------------
     */
    @RequestMapping("sendMessage")
    @ResponseBody
    public JsonResult sendMessage(String RegisterTel) {
    phoneNumberService.sendMessage(RegisterTel);
        return new JsonResult();
    }

}
