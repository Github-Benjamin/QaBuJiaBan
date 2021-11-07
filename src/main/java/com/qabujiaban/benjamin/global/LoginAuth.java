package com.qabujiaban.benjamin.global;

/**
 * @Author: benjamin_v@qq.com
 * @Date: 2021/11/5 20:29
 */

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/*
    日志打印和拦截器功能冲突 WebLogAspect loginAuth
 */

@WebFilter(filterName = "loginAuth", urlPatterns  = {"/admin","/backMessage","/GetAllUSerCount","/GetDayUserCount","/getMessagePageInfo","/deleteMessageId","/updateMessage"})
public class LoginAuth implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        String requestURI = request.getRequestURI();
        if (!requestURI.contains("Login")) {
            if (session != null && session.getAttribute("name") != null) {
                filterChain.doFilter(request, response);
            } else {
                String requestType = request.getHeader("X-Requested-With");
                if (requestType != null && "XMLHttpRequest".equals(requestType)) {
                    response.getWriter().write("NO_LOGIN");
                } else {
                    response.sendRedirect(request.getContextPath() + "/Login");
                }
                return;
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }

}

