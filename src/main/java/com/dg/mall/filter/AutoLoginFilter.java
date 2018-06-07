package com.dg.mall.filter;

import com.dg.mall.pojo.Admin;
import com.dg.mall.pojo.Result;
import com.dg.mall.service.AdminService;
import com.dg.mall.service.impl.AdminServiceImpl;
import com.dg.mall.utils.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AutoLoginFilter implements Filter {
    @Autowired
    private AdminService adminService;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //自动登录
        Cookie[] cookies = request.getCookies();
        String username = null;
        String password = null;
        HttpSession session = request.getSession();
        //取出cookies包含cookie_username cookie_password的值
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cookie_username")) {
                    username = cookie.getValue();
                }
                if (cookie.getName().equals("cookie_password")) {
                    password = cookie.getValue();
                }
            }
        }
        //登录密码账号不为空，且未登录，执行自动登陆
        if (TextUtils.notEmpty(username) && TextUtils.notEmpty(password) && session.getAttribute("admin") == null) {
            System.out.println(username + " " + password);
            Admin admin = new Admin();
            admin.setUsername(username);
            admin.setPassword(password);
            XmlWebApplicationContext cxt = (XmlWebApplicationContext) WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
            if (cxt != null && cxt.getBean("adminServiceImpl") != null && adminService == null) {
                adminService = (AdminService) cxt.getBean("adminServiceImpl");
            }
            System.out.println("自动登录");
            Result result = adminService.getLoginResult(admin);
            System.out.println("aaaaa");

            System.out.println("ssss:" + (result.getData() == null));

            session.setAttribute("admin", result.getData());
            System.out.println("xxxxx");

        }
        String currentUrl = request.getRequestURI();
        String adminUrl=request.getContextPath() + "/admin";
        String loginUrl=request.getContextPath() + "/login";

        //未登录跳转到登录页面
        if (TextUtils.isEmpty(username) && TextUtils.isEmpty(password) && session.getAttribute("admin") == null &&!currentUrl.equals(adminUrl)&&!currentUrl.equals(loginUrl)) {
            System.out.println("未登录自动跳转登录页");
            response.sendRedirect(adminUrl);
            return;
        }
        //一方通行
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }


}
