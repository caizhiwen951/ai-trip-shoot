package com.bj.lp.sys.controller;


import com.bj.lp.common.vo.JsonResult;
import com.bj.lp.sys.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class LoginController {
/**----------------------------------------登录-------------------------------------------------*/
    @Autowired
    private LoginService loginService;

    @RequestMapping("/")
    public String doIndex() {
        return "/test.html";
    }

    //用户登录的操作
    @RequestMapping(value = "findUsername")
    @ResponseBody
    public JsonResult findUsername(String username, String password, boolean isRememberMe) {
        loginService.findUsername(username, password);
        /*UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        if (isRememberMe) {
            token.setRememberMe(true);
        }
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);*/
        return new JsonResult("登录成功");
    }
}
