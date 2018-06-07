package com.dg.mall.controller;

import com.dg.mall.pojo.Admin;
import com.dg.mall.pojo.Result;
import com.dg.mall.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public String adminLogin(Admin admin, Model model, String online, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("adminLogin");
        Result result = adminService.getLoginResult(admin);
        if (result.getStatus() == 200) {
            if (online != null) {
                System.out.println(online);
                Cookie cookie_username = new Cookie("cookie_username", admin.getUsername());
                Cookie cookie_password = new Cookie("cookie_password", admin.getUsername());
                //设置cookie的持久化时间
                cookie_username.setMaxAge(60 * 60);
                cookie_password.setMaxAge(60 * 60);
                //设置cookie的携带路径
                cookie_username.setPath(request.getContextPath());
                cookie_password.setPath(request.getContextPath());
                //发送cookie
                response.addCookie(cookie_username);
                response.addCookie(cookie_password);
            }
            HttpSession session = request.getSession();
            session.setAttribute("admin",result.getData());
            System.out.println("zz:"+request.getSession().getAttribute("admin")==null);
            return "redirect:/admin/index";
        } else {
            model.addAttribute("result", result);
            return "/login";
        }
    }
}
