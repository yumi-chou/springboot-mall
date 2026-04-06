package com.yumi.springbootmall.dao;

import com.yumi.springbootmall.dto.UserRegisterRequest;
import com.yumi.springbootmall.model.User;

public interface UserDao {
    Integer createUser(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);
}
