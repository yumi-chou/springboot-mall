package com.yumi.springbootmall.service;

import com.yumi.springbootmall.dto.ProductRequest;
import com.yumi.springbootmall.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
}
