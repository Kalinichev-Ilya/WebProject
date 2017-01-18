package com.webproject.filters;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthorizationFilter extends MainFilter {
//    private static final String AUTH_KEY = "AUTH_KEY";
//    private String userID = "";

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
//        Cookie[] cookies = request.getCookies();
//
//        if (cookies != null) {
////
////            for (Cookie cookie : cookies) {
////
////                if (cookie.getName().equals(AUTH_KEY)) {
////                    String authKeyFromCookie = cookie.getValue();
////                    JdbcService jdbcService = new JdbcService();
////                    try {
////                        Connection con = jdbcService.getConnection();
////                        if (jdbcService.validateAuthKeyFromDB(con, authKeyFromCookie)){
////                            String userID = jdbcService.getValueFromDB(con,
////                                    "ID", "AUTHORIZATION", "AUTH_KEY", authKeyFromCookie);
////                            String firstName = jdbcService.getValueFromDB(con,
////                                    "FIRST_NAME", "USERS", "ID", userID);
////                            request.setAttribute("userID", firstName );
////
////                            filterChain.doFilter(request, response);
////                        }
////                    } catch (AnythingWithDataBaseConnectionException e) {
////                    }
////                }
////            }
//            filterChain.doFilter(request, response);
//        } else {
//            request.setAttribute("message", "You must login to access the site.");
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
//            dispatcher.forward(request, response);
//        }
//    }
        HttpSession session = request.getSession(false);
        String loginURI = request.getContextPath() + "/login";
        boolean loggedIn = session != null && session.getAttribute("user") != null; //TODO разобраться с атрибутом ссессии.
        System.out.println(session.getAttribute("user").toString());
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        if (loggedIn || loginRequest) {
            filterChain.doFilter(request, response);
        } else {
            response.sendRedirect(loginURI);
        }
    }
}