package com.yumi.springbootmall.service;

import com.yumi.springbootmall.dto.CreateOrderRequest;
import org.springframework.stereotype.Component;

@Component
public interface OrderService {
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
