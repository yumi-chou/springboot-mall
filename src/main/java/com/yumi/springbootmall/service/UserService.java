package com.yumi.springbootmall.service;

import com.yumi.springbootmall.dto.UserRegisterRequest;
import com.yumi.springbootmall.model.User;

public interface UserService {
    Integer register(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);
}
