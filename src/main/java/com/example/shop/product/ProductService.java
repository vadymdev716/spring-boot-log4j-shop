package com.example.shop.product;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public interface ProductService {

   CompletableFuture<List<Product>> getProductList(String condition);
}
