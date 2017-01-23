package com.webproject.listeners;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

public class DBCPContextListener implements ServletContextListener {

    private DataSource dataSource;

    @Override
    public void contextInitialized(ServletContextEvent event) {

        ServletContext servletContext = event.getServletContext();
        try {
            dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/webprojectDB");
            System.out.println("Datasource was create.");
        } catch (NamingException e) {
            throw new RuntimeException("Config failed: datasource not found", e);
        }
        servletContext.setAttribute("jdbc/webprojectDB", this);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {

    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public static DBCPContextListener getInstance(ServletContext servletContext) {
        return (DBCPContextListener)servletContext.getAttribute("jdbc/webprojectDB");
    }
}