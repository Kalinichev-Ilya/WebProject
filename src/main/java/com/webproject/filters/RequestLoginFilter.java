package com.webproject.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class RequestLoginFilter extends MainFilter {
    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        Enumeration<String> params = request.getParameterNames();
        while (params.hasMoreElements()) {
            String name = params.nextElement();
            String value = request.getParameter(name);
        }

        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie: cookies){
                //NOP
            }
        }
        filterChain.doFilter(request,response);
    }
}
