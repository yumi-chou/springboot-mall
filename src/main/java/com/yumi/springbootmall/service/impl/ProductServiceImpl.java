package com.yumi.springbootmall.service.impl;


import com.yumi.springbootmall.dao.ProductDao;
import com.yumi.springbootmall.dto.ProductRequest;
import com.yumi.springbootmall.model.Product;
import com.yumi.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest) ;
    }
}
