package com.yumi.springbootmall.dao;

import com.yumi.springbootmall.dto.UserRegisterRequest;
import com.yumi.springbootmall.model.User;

public interface UserDao {
    User getUserById(Integer userId);

    User getUserByEmail(String email);

    Integer createUser(UserRegisterRequest userRegisterRequest);
}
