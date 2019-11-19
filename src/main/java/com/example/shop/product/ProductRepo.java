package com.example.shop.product;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo {

    List<Product> getProducts();
}
