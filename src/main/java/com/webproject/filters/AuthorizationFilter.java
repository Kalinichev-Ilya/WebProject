package com.webproject.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthorizationFilter extends MainFilter {

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        //TODO Сделать исключение по url
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();
        boolean userCookie = false;

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("user")) {
                userCookie = true;
            }
        }
        boolean loggedIN = session != null && userCookie;

        if (!loggedIN) {
            System.out.println("filter - > logged in = " + loggedIN + " LOGIN VALIDATE FALSE, relogin.");

            response.sendRedirect("/relogin");
            return;
        } else {
            System.out.println("filter - > logged in = " + loggedIN + " LOGIN VALIDATE OK, set redirect to user page.");

            response.sendRedirect("/user");
        }
    }
}
