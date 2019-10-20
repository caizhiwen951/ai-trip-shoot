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
        System.out.println(123);
        return moduleUI;
    }


    @RequestMapping("chatUI")
    public String chatUI(){
        return "../chat-list";
    }

}
