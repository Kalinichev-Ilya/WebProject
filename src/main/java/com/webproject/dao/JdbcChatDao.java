package com.webproject.dao;

import com.webproject.entity.Chat;
import com.webproject.exceptions.PersistException;

import java.sql.Connection;
import java.util.List;

//TODO Дописать реализации
public class JdbcChatDao implements GenericDao<Chat, Integer> {

    /**Создает новый Чат согласно соответсвующему объекту*/
    @Override
    public Chat create(Connection conn, Chat chat) throws PersistException {

        return null;
    }

    /** Возвращает Чат соответствующий записи с первичным ключом key или null */ //TODO реализовать getID из БД по чату
    @Override
    public Chat getByPK(Integer key, Connection conn) throws PersistException {
        return null;
    }

    /** Сохраняет состояние объекта Чата в базе данных */
    @Override
    public void update(Chat object, Connection conn) throws PersistException {

    }

    /** Удаляет запись об объекте Чата из базы данных */
    @Override
    public void delete(Chat object, Connection conn) throws PersistException {

    }

    /** Возвращает список всех Чатов соответствующих всем записям в базе данных */
    @Override
    public List<Chat> getAll(Connection conn) throws PersistException {
        return null;
    }
}
