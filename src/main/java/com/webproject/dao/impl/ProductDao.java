package com.webproject.dao.impl;

import com.webproject.dao.exceptions.DaoSystemException;
import com.webproject.dao.exceptions.NoSuchEntityException;
import com.webproject.entity.User;

import java.util.List;

/**
 * @author Averchenkov R.A.
 */
public interface ProductDao {
    User selectById(int id) throws DaoSystemException, NoSuchEntityException;
    List<User> selectAll() throws DaoSystemException;
}
