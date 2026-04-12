package com.yumi.springbootmall.service;

import com.yumi.springbootmall.dto.CreateOrderRequest;
import com.yumi.springbootmall.model.Order;
import org.springframework.stereotype.Component;

@Component
public interface OrderService {

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
