package com.webproject.controller;

import com.webproject.exception.ExistsUserSignUpException;
import com.webproject.exception.SignUpException;
import com.webproject.service.SignUpService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {

    private final SignUpService signUpService;

    public SignUpServlet(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirm_password");
        try {
            signUpService.signUp(login, password);
        } catch (ExistsUserSignUpException e) {
        } catch (SignUpException e) {
        }
    }
}