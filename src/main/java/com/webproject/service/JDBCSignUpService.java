package com.webproject.service;

import com.webproject.domain.User;
import com.webproject.exception.DataAccessException;
import com.webproject.exception.ExistsUserSignUpException;
import com.webproject.exception.SignUpException;
import com.webproject.repository.UserRepository;

import java.security.MessageDigest;
import java.security.SignatureException;
import java.util.Optional;

public class JDBCSignUpService implements SignUpService {

    private final UserRepository userRepository;

    public JDBCSignUpService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void signUp(String userName, String password) throws SignUpException {
        String passwordMD5 = md5(password).orElseThrow(SignUpException::new);
        User user = new User(userName, passwordMD5);
        Optional<User> existsUser = userRepository.findOne(userName);
        if (existsUser.isPresent()) {
            throw new ExistsUserSignUpException();
        }
        try {
            userRepository.save(user);
        } catch (DataAccessException e) {
            throw new SignUpException(e.getMessage(), e);
        }
    }

    private Optional<String> md5(String md5) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return Optional.of(sb.toString());
        } catch (java.security.NoSuchAlgorithmException e) {
            return Optional.empty();
        }
    }

}
