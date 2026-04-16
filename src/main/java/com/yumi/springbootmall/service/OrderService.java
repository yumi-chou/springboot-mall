package com.yumi.springbootmall.service;

import com.yumi.springbootmall.dto.CreateOrderRequest;
import com.yumi.springbootmall.dto.OrderQueryParams;
import com.yumi.springbootmall.model.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderService {
    Integer countOrder(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
