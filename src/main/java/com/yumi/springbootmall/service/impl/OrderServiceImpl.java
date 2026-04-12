package com.yumi.springbootmall.service.impl;

import com.yumi.springbootmall.dao.OrderDao;
import com.yumi.springbootmall.dao.ProductDao;
import com.yumi.springbootmall.dto.BuyItem;
import com.yumi.springbootmall.dto.CreateOrderRequest;
import com.yumi.springbootmall.model.Order;
import com.yumi.springbootmall.model.OrderItem;
import com.yumi.springbootmall.model.Product;
import com.yumi.springbootmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public Order getOrderById(Integer orderId) {
        Order order = orderDao.getOrderById(orderId);

        List<OrderItem> orderItemList = orderDao.getOrderItemsByOrderId(orderId);

        order.setOrderItemList(orderItemList);

        return order;
    }

    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {
        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();

        for(BuyItem buyitem : createOrderRequest.getBuyItemList()){
            Product product = productDao.getProductById(buyitem.getProductId());

            // 總價
            int amount = product.getPrice() * buyitem.getQuantity();
            totalAmount = totalAmount + amount;

            // buyItem 轉換成 orderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyitem.getProductId());
            orderItem.setQuantity(buyitem.getQuantity());
            orderItem.setAmount(amount);

            orderItemList.add(orderItem);
        }

        //創建訂單
        Integer orderId = orderDao.createOrder(userId, totalAmount);

        orderDao.createOrderItems(orderId, orderItemList);

        return orderId;
    }
}
