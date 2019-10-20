package com.bj.lp.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/")
public class PageController {

    /**返回分页页面*/
    @RequestMapping("doPageUI")
    public String doPageUI() {
        return "common/page";
    }

    @RequestMapping("{moduleUI}")
    public String doModuleUI(
            @PathVariable String moduleUI) {
        return moduleUI;
    }

}
