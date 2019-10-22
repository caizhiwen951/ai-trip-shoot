package com.bj.lp.sys.controller;

import com.bj.lp.common.vo.JsonResult;
import com.bj.lp.sys.service.GetCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class GetCodeController {

    @Autowired
    private GetCodeService getCodeService;

    /**--------------------------------------------------------生成验证码--------------------------------------------------------*/
    @RequestMapping("getCode")
    @ResponseBody
    public JsonResult getCode(String Code, String RegisterTel) {
        getCodeService.getCode(Code, RegisterTel);
        return new JsonResult();
    }

}
