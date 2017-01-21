package com.webproject.servlets;


import com.webproject.entity.User;
import com.webproject.exceptions.AnythingWithDataBaseConnectionException;
import com.webproject.listeners.DBCPContextListener;
import com.webproject.service.JdbcService;
import com.webproject.service.SecurityService;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ReloginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/relogin.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JdbcService jdbcService = new JdbcService();
        Connection conn = null;

        String login = request.getParameter("login");
        String password = request.getParameter("pwd");
        String hashUserPwd = SecurityService.md5(password).toString();
        try {
            DataSource dataSource = DBCPContextListener.getInstance(getServletContext()).getDataSource();
            conn = dataSource.getConnection();
            User user = jdbcService.find(conn, login, hashUserPwd);

            System.out.println("RELOGIN -> " + (login.equals(user.getLogin()) && hashUserPwd.equals(user.getPassword())));
            if (login.equals(user.getLogin()) && hashUserPwd.equals(user.getPassword())) {
                HttpSession session = request.getSession(true);
                session.setAttribute("user", user.getLogin());
                session.setMaxInactiveInterval(60 * 60 * 24);

                Cookie userCookie = new Cookie("user", user.getLogin());
                userCookie.setMaxAge(60 * 60 * 24);
                response.addCookie(userCookie);

                response.sendRedirect("/user");
                return;
//            } else {
//                request.setAttribute("message", "Wrong user name or password.");
//                RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/relogin.jsp");
//                rd.include(request, response);
//                return;
            }
        } catch (AnythingWithDataBaseConnectionException e) {
            request.setAttribute("error", "AnythingWithDataBaseConnectionException Please try again later.");
            request.getRequestDispatcher("/WEB-INF/jsp/relogin.jsp").forward(request, response);
        } catch (SQLException e) {
            System.out.println("WHAT HAPPENS FROM RELOGIN SERVLET.");
            e.printStackTrace();
//        } catch (NamingException e) {
//            e.printStackTrace();
        }
    }
}


