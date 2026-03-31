package com.yumi.springbootmall.service.impl;


import com.yumi.springbootmall.constant.ProductCategory;
import com.yumi.springbootmall.dao.ProductDao;
import com.yumi.springbootmall.dto.ProductQueryParams;
import com.yumi.springbootmall.dto.ProductRequest;
import com.yumi.springbootmall.model.Product;
import com.yumi.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Integer getAllProducts(ProductQueryParams productQueryParams) {
        return productDao.getAllProducts(productQueryParams);
    }

    @Override
    public List<Product> getProducts(ProductQueryParams productQueryParams) {
        return productDao.getProducts(productQueryParams);
    }

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest) ;
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        productDao.updateProduct(productId, productRequest);
    }

    @Override
    public void deleteProduct(Integer productId) {
        productDao.deleteProduct(productId);
    }
}
