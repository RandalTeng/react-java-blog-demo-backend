package com.blog.services;

import com.blog.dao.UserDao;


import com.blog.models.User;
import com.blog.util.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * com.blog.services
 *
 * @author Created by randal on 18-6-27.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public Set<String> errors = new HashSet<String>() {};

    public UserDao getUserDao() {
        return this.userDao;
    }

    public String getError() {
        return errors.iterator().next();
    }

    public void addError(String value) {
        this.errors.add(value);
    }

    public void cleanError() {
        this.errors.clear();
    }

    @Transactional
    public boolean login(String username, String password) throws NoSuchAlgorithmException {
        User user = findByUsername(username);
        if (user == null) {
            errors.add("用户不存在");
            return false;
        }

        if (!user.getPassword().equals(Security.string2Md5(password.concat(user.getSalt())))) {
            errors.add("密码错误");
            return false;
        }

        return true;
    }

    public boolean login(User user, String password) throws NoSuchAlgorithmException {
        if (user == null) {
            errors.add("用户不存在");
            return false;
        }

        if (!user.getPassword().equals(Security.string2Md5(Security.string2Md5(password).concat(user.getSalt())))) {
            errors.add("密码错误");
            return false;
        }

        return true;
    }

    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
