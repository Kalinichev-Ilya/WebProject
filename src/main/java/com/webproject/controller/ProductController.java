package com.webproject.controller;

import com.webproject.dao.impl.ProductDao;
import com.webproject.dao.exceptions.DaoSystemException;
import com.webproject.dao.exceptions.NoSuchEntityException;
import com.webproject.dao.ProductDaoMock;
import com.webproject.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductController extends HttpServlet {
    public static final String PARAM_ID = "id";
    public static final String ATTRIBUTE_MODEL_TO_VIEW = "product";
    public static final String PAGE_OK = "user.jsp";
    public static final String PAGE_ERROR = "error.jsp";

    private ProductDao productDao = new ProductDaoMock();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter(PARAM_ID);
        if(idStr != null){
            try {
                Integer id = Integer.valueOf(idStr);
                User model = productDao.selectById(id);
                req.setAttribute(ATTRIBUTE_MODEL_TO_VIEW, model);
                //OK
                req.getRequestDispatcher(PAGE_OK).forward(req,resp);
                return;
            } catch (NumberFormatException  | NoSuchEntityException | DaoSystemException e){
                /*NOP*/
            }
        }
        // FAIL
        resp.sendRedirect(PAGE_ERROR);
    }
}
