package com.bj.lp.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/")
public class PageController {


    //iii
    @RequestMapping("{moduleUI}")
    public String doModuleUI(
            @PathVariable String moduleUI) {
        return moduleUI;
    }

}
