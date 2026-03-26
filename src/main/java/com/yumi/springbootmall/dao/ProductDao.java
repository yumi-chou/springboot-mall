package com.yumi.springbootmall.dao;

import com.yumi.springbootmall.dto.ProductRequest;
import com.yumi.springbootmall.model.Product;

public interface ProductDao {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProduct(Integer productId);
}
