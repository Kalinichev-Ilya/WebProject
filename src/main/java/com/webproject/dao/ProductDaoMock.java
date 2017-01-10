package com.webproject.dao;

import com.webproject.dao.exceptions.DaoSystemException;
import com.webproject.dao.exceptions.NoSuchEntityException;
import com.webproject.dao.impl.ProductDao;
import com.webproject.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProductDaoMock implements ProductDao {
    private final Map<Integer, User> memory = new ConcurrentHashMap<>();

    public ProductDaoMock() {
        this.memory.put(1, new User(1, "Bread"));
        this.memory.put(2, new User(2, "Paper"));
        this.memory.put(3, new User(3, "Sugar"));
    }

    @Override
    public User selectById(int id) throws DaoSystemException, NoSuchEntityException {
        if (!memory.containsKey(id)){
            throw new NoSuchEntityException("No User for id == '" + id + "', only");
        }
        return memory.get(id);
    }

    @Override
    public List<User> selectAll() throws DaoSystemException {
        return new ArrayList<>(memory.values());
    }
}
