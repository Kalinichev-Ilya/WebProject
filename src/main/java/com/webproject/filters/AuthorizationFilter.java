package com.webproject.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthorizationFilter extends MainFilter {

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        HttpSession session = request.getSession(false);
        boolean loggedOut = session != null && session.getAttribute("user") != null; //TODO разобраться с атрибутом ссессии.
        if (loggedOut) {
            System.out.println("filter - > loggedOut = " + loggedOut + " LOGIN VALIDATE FALSE, relogin.");

            response.sendRedirect("/relogin");
        } else {
            System.out.println("filter - > loggedOut = " + loggedOut + " LOGIN VALIDATE OK, set redirect to user page.");

            response.sendRedirect("/user");
        }
    }
}
