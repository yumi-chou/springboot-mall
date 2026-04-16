package com.yumi.springbootmall.service.impl;

import com.yumi.springbootmall.dao.OrderDao;
import com.yumi.springbootmall.dao.ProductDao;
import com.yumi.springbootmall.dao.UserDao;
import com.yumi.springbootmall.dto.BuyItem;
import com.yumi.springbootmall.dto.CreateOrderRequest;
import com.yumi.springbootmall.dto.OrderQueryParams;
import com.yumi.springbootmall.model.Order;
import com.yumi.springbootmall.model.OrderItem;
import com.yumi.springbootmall.model.Product;
import com.yumi.springbootmall.model.User;
import com.yumi.springbootmall.service.OrderService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;


@Component
public class OrderServiceImpl implements OrderService {
    private final static Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public Integer countOrder(OrderQueryParams orderQueryParams) {
        return orderDao.countOrder(orderQueryParams);
    }

    @Override
    public List<Order> getOrders(OrderQueryParams orderQueryParams) {
        List<Order> orderList = orderDao.getOrders(orderQueryParams);

        for(Order order : orderList){
            List<OrderItem> orderItemList = orderDao.getOrderItemsByOrderId(order.getOrderId());

            order.setOrderItemList(orderItemList);
        }

        return orderList;
    }

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

        //檢查user是否存在
        User user = userDao.getUserById(userId);

        if(user == null){
            log.warn("該userId {} 不存在", userId);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();

        for(BuyItem buyitem : createOrderRequest.getBuyItemList()){
            Product product = productDao.getProductById(buyitem.getProductId());

            // 檢查 product 是否存在、庫存是否足夠
            if(product == null){
                log.warn("商品 {} 不存在", buyitem.getProductId());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }else if(product.getStock() < buyitem.getQuantity()){
                log.warn("商品 {} 庫存不足，剩餘數量{}，欲購買數量{}",
                        buyitem.getProductId(),product.getStock(),buyitem.getQuantity());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }

            productDao.updateStock(product.getProductId(), product.getStock()-buyitem.getQuantity());


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
