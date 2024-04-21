package com.zhang.ssmschoolshop.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        // 检查用户是否已经登录，通常是检查session或者token
        if (request.getSession().getAttribute("admin") != null) {
            Object admin = request.getSession().getAttribute("admin");
            Object user = request.getSession().getAttribute("user");
            return true; // 继续执行后续的拦截器和请求处理
        } else {
            // 用户未登录，可以重定向到登录页面或返回一个错误信息
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 设置状态码为401
            System.out.println(request.getRequestURL());
            log.info(request.getRequestURL().toString());
            response.sendRedirect("/shop/admin/login");
            return false; // 不继续执行后续的拦截器和请求处理
        }
    }
}