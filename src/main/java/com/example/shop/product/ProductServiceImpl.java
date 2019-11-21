package com.example.shop.product;

import com.example.shop.product.filter.ProductFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepo productRepo;
    private ProductFilter productFilter;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo, ProductFilter productFilter) {
        this.productRepo = productRepo;
        this.productFilter = productFilter;
    }

    @Async
    @Override
    public CompletableFuture<List<Product>> getProductList(String condition) {
        List<Product> products = productRepo.getProducts();
        List<Product> filteredProducts = productFilter.nameRegularExpressionFilter(products, condition);
        return CompletableFuture.completedFuture(filteredProducts);
    }
}
