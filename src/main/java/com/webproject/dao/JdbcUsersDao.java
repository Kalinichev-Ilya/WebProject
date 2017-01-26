package com.webproject.dao;

import com.webproject.entity.User;
import com.webproject.exceptions.PersistException;

import java.sql.Connection;
import java.util.List;

//TODO дописать
public class JdbcUsersDao implements GenericDao<User, Integer> {

    @Override
    public String create(User objects) throws PersistException {
        return null;
    }

    @Override
    public User getByID(Integer key, Connection conn) throws PersistException {
        return null;
    }

    @Override
    public void update(User object, Connection conn) throws PersistException {

    }

    @Override
    public void delete(User object, Connection conn) throws PersistException {

    }

    @Override
    public List<User> getAll(Connection conn) throws PersistException {
        return null;
    }
}
