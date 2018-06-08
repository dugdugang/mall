package com.dg.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PageController {

    @RequestMapping("/admin")
    public String showAdmin( HttpServletRequest request){
        System.out.println(request.getSession().getAttribute("admin")==null);
        return "login";
    }

    @RequestMapping("/admin/{page}")
    public String showPage(@PathVariable String page, HttpServletRequest request){
        System.out.println("当前用户："+request.getSession().getAttribute("admin")==null);
        return page;
    }

}
