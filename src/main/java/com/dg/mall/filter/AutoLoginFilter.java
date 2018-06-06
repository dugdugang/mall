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
        Cookie[] cookies = request.getCookies();
        String username = null;
        String password = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cookie_username")) {
                    username = cookie.getName();
                }
                if (cookie.getName().equals("cookie_password")) {
                    password = cookie.getName();
                }
            }
        }

        if (TextUtils.notEmpty(username) && TextUtils.notEmpty(password)) {
            Admin admin = new Admin();
            admin.setUsername(username);
            admin.setPassword(password);

            XmlWebApplicationContext cxt =(XmlWebApplicationContext) WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());

            if(cxt != null && cxt.getBean("adminServiceImpl") != null && adminService == null) {
                adminService = (AdminService) cxt.getBean("adminServiceImpl");
            }
            Result result = adminService.getLoginResult(admin);
            HttpSession session = request.getSession();
            session.setAttribute("admin", result.getData());
        }
        //方行
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }





}
