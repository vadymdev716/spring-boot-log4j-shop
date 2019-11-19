package com.example.shop.product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> getProductList(String condition);
}
