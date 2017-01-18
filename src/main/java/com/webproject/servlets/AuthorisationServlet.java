package com.webproject.servlets;

import com.webproject.entity.User;
import com.webproject.exceptions.InvalidPasswordException;
import com.webproject.exceptions.AnythingWithDataBaseConnectionException;
import com.webproject.service.JdbcService;
import com.webproject.service.SecurityService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;

public class AuthorisationServlet extends HttpServlet {
    JdbcService jdbcService = new JdbcService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("pwd");
        String hashUserPwd = SecurityService.md5(password).toString();
        try {
            Connection con = jdbcService.getConnection();
            User user = jdbcService.find(con, login, hashUserPwd);
            if (user != null) {
                request.getSession().setAttribute("user", user.getLogin()); //TODO где спрятался?

                response.sendRedirect("/WEB-INF/jsp/user");
            }
        } catch (InvalidPasswordException e) {
            request.setAttribute("error", "InvalidPasswordException Unknown user or wrong password, please try again.");
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        } catch (AnythingWithDataBaseConnectionException e) {
            request.setAttribute("error", "AnythingWithDataBaseConnectionException Please try again later.");
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        }
    }
    //    JdbcService signUp;
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
//        System.out.println("authorization!!");
//        req.getCookies();
//        Cookie[] cookies = req.getCookies();
//        if (cookies != null) {
//            System.out.println(cookies.length);
//            for (Cookie cookie : cookies) {
//                System.out.println(cookie.getName());
//                if (cookie.getName().equals("auth_key")) {
//                    System.out.println(cookie.getName());
//                    String authKeyFromCookie = cookie.getValue();
//                    System.out.println("cookie.getValue = " + authKeyFromCookie);
//                    JdbcService jdbcService = new JdbcService();
//                    try {
//                        Connection con = jdbcService.getConnection();
//                        if (signUp.validateAuthKeyFromDB(con, authKeyFromCookie)) {
//                            System.out.println("if (signUp.validateAuthKeyFromDB(con, authKeyFromCookie)) {");
//                            String userID = jdbcService.getValueFromDB(con,
//                                    "ID", "AUTHORIZATION", "AUTH_KEY", authKeyFromCookie);
//                            String login = jdbcService.getValueFromDB(con,
//                                    "LOGIN", "USERS", "ID", userID);
//                            req.setAttribute("userName", login);
//                            dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/user.jsp");
//                            dispatcher.forward(req, resp);
//                            return;
//                        }
//                    } catch (AnythingWithDataBaseConnectionException e) {
//                    }
//                }
//            }
//            dispatcher.forward(req, resp);
//        }
//    }
//
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String userLogin = req.getParameter("login");
//        String userPwd = req.getParameter("pwd");
//        String hashUserPwd = SecurityService.md5(userPwd).toString();
//        try {
//            signUp = new JdbcService(userLogin, hashUserPwd);
//            Connection con = signUp.getConnection();
//            boolean inputDataValid = signUp.validateLoginFromDB(con);
//            String hashUserLogin = SecurityService.md5(userLogin).toString();
//            if (inputDataValid) {
//                Cookie userNameCookie = new Cookie("auth_key", hashUserLogin);
//                userNameCookie.setMaxAge(30 * 60);
//                resp.addCookie(userNameCookie);
//                resp.sendRedirect("/user");
//                return;
//            }
//        } catch (ExistsUserException | InvalidPasswordException e) {
//            req.setAttribute("message", "Invalid login or password.");
//            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
//            dispatcher.forward(req, resp);
//            return;
//        } catch (AnythingWithDataBaseConnectionException e) {
//        }
//    }
}



