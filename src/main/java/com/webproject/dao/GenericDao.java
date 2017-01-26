package com.webproject.dao;

import com.webproject.exceptions.PersistException;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

/**
 * Унифицированный интерфейс управления персистентным состоянием объектов
 *
 * @param <T>  тип объекта базы данных
 * @param <PK> тип первичного ключа
 */
public interface GenericDao<T extends Serializable, PK extends Serializable> {

    /**
     * Создает новую запись согласно соответствующему объекту
     */
    public String create(T objects) throws PersistException;

    /**
     * Возвращает объект соответствующий записи с первичным ключом key.
     */
    public T getByID(PK key, Connection conn) throws PersistException;

    /**
     * Сохраняет обновленное состояние объекта в базе данных.
     */
    public void update(T object, Connection conn) throws PersistException;

    /**
     * Удаляет запись об объекте из базы данных.
     */
    public void delete(T object, Connection conn) throws PersistException;

    /**
     * Возвращает список объектов соответствующих всем записям в базе данных.
     */
    public List<T> getAll(Connection conn) throws PersistException;
}
