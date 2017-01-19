package com.webproject.servlets;

import com.webproject.entity.User;
import com.webproject.exceptions.AnythingWithDataBaseConnectionException;
import com.webproject.filters.AuthorizationFilter;
import com.webproject.service.JdbcService;
import com.webproject.service.SecurityService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;

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

        String login = request.getParameter("login");
        String password = request.getParameter("pwd");
        String hashUserPwd = SecurityService.md5(password).toString();
        try {
            Connection con = jdbcService.getConnection();
            User user = jdbcService.find(con, login, hashUserPwd);

            if (login.equals(user.getLogin()) && hashUserPwd.equals(user.getPassword())) {

                HttpSession session = request.getSession(true);
                session.setAttribute("user", user.getLogin());
                session.setMaxInactiveInterval(60 * 60 * 24);

                Cookie userCookie = new Cookie("user", user.getLogin());
                userCookie.setMaxAge(60 * 60 * 24);
                response.addCookie(userCookie);

                response.sendRedirect("/user");
                return;
            } else {
                request.setAttribute("message", "Wrong user name or password.");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/relogin");
                rd.include(request, response);
                return;
            }
        } catch (AnythingWithDataBaseConnectionException e) {
            request.setAttribute("error", "AnythingWithDataBaseConnectionException Please try again later.");
            request.getRequestDispatcher("/WEB-INF/jsp/relogin").forward(request, response);
        }
    }
}
