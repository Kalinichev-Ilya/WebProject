package com.webproject.service;

import com.webproject.exception.SignUpException;

/**
 * Интерфейс для регистрации пользователя.
 */
public interface SignUpService {
    /**
     * Метод для регистрации пользователя
     *
     * @param userName имя пользователя
     * @param password пароль
     * @throws SignUpException если произошла ошибка при регистрации
     */
   void signUp (String userName, String password) throws SignUpException;
}
