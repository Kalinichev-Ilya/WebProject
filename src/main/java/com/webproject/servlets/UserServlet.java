package com.webproject.servlets;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/user.jsp");
        System.out.println(">> User servlet <<");
        Cookie[] coookies = req.getCookies();

        for(Cookie cookie : coookies){
            if(cookie.getName().equals("user")) {
                req.setAttribute("user", cookie.getValue());
            }
        }
        //TODO Вывести таблицу Users;
        dispatcher.forward(req, resp);
    }
}
