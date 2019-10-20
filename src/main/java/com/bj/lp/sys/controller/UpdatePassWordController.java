package com.bj.lp.sys.controller;


import com.bj.lp.common.vo.JsonResult;
import com.bj.lp.common.vo.Node;
import com.bj.lp.sys.service.updatePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class UpdatePassWordController {

    @Autowired
    private Node node;

    @Autowired
    private com.bj.lp.sys.service.updatePasswordService updatePasswordService;

    /** -----------------------------------------------修改密码--------------------------------------------------*/
    @RequestMapping("updatePassword")
    @ResponseBody
    public JsonResult checkWord(String newPassword) {
        String phoneNum = node.getPhoneNum();
        updatePasswordService.updatePassword(newPassword,phoneNum);
        return new JsonResult();
    }
}
