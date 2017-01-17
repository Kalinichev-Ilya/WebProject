package com.webproject.servlets;

import com.webproject.exceptions.ExistsUserSignUpException;
import com.webproject.exceptions.InvalidPasswordException;
import com.webproject.exceptions.SignUpException;
import com.webproject.service.JdbcService;
import com.webproject.service.SecurityService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;

public class LoginServlet extends HttpServlet {
    JdbcService signUp;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userLogin = req.getParameter("login");
        String userPwd = req.getParameter("pwd");
        String hashUserPwd = SecurityService.md5(userPwd).toString();

        try {
            signUp = new JdbcService(userLogin, hashUserPwd);
            Connection con = signUp.getConnection();
            boolean inputDataValid = signUp.validateDataFromDB(con);
            String hashUserLogin = SecurityService.md5(userLogin).toString();
            if(inputDataValid) {
                Cookie userNameCookie = new Cookie("auth_key", hashUserLogin);
                userNameCookie.setMaxAge(30 * 60);
                resp.addCookie(userNameCookie);
                resp.sendRedirect("/user");
            }
        } catch (ExistsUserSignUpException | InvalidPasswordException e) {
            req.setAttribute("message", "Invalid login or password.");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            dispatcher.forward(req, resp);
        } catch (SignUpException e) {
        }

    }

}
