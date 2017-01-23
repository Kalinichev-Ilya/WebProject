package com.webproject.dao;

import com.webproject.exceptions.PersistException;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

/**
 * Унифицированный интерфейс управления персистентным состоянием объектов
 * @param <T> тип объекта базы данных
 * @param <PK> тип первичного ключа
 */
public interface GenericDao<T extends Serializable, PK extends Serializable> {

    /** Создает новую запись согласно соответствующему объекту */
    public T create(Connection conn, T objects) throws PersistException;

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    public T getByPK(PK key, Connection conn) throws PersistException;

    /** Сохраняет состояние объекта group в базе данных */
    public void update(T object, Connection conn) throws PersistException;

    /** Удаляет запись об объекте из базы данных */
    public void delete(T object, Connection conn) throws PersistException;

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    public List<T> getAll(Connection conn) throws PersistException;
}
