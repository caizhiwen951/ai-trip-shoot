package com.bj.lp.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/")
public class PageController {
    @RequestMapping("{moduleUI}")
    public String doModuleUI(
            @PathVariable String moduleUI) {
        return moduleUI;
    }
    @RequestMapping("page")
    public String doIndexUI() {
        return "index";
    }

    @RequestMapping("chatUI")
    public String chatUI(){
        return "../chat-list";
    }

    @RequestMapping("lpcs")
    public String doIndexUI1() {
        return "LPCS";
    }

}
