package com.dg.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/admin")
    public String showAdmin(){
        return "login";
    }

    @RequestMapping("/admin/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }

}
