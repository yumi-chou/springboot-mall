package com.yumi.springbootmall.service;

import com.yumi.springbootmall.constant.ProductCategory;
import com.yumi.springbootmall.dto.ProductQueryParams;
import com.yumi.springbootmall.dto.ProductRequest;
import com.yumi.springbootmall.model.Product;

import java.util.List;

public interface ProductService {
    Integer getAllProducts(ProductQueryParams productQueryParams);

    List<Product> getProducts(ProductQueryParams productQueryParams);;

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId,ProductRequest productRequest);

    void deleteProduct(Integer productId);
}
