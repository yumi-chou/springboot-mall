package com.yumi.springbootmall.service.impl;

import com.yumi.springbootmall.dao.UserDao;
import com.yumi.springbootmall.dto.UserRegisterRequest;
import com.yumi.springbootmall.model.User;
import com.yumi.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }
}
