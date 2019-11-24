package com.example.shop.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("/shop/product")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProductList(@RequestParam String nameFilter) throws InterruptedException,
            ExecutionException, TimeoutException {
        return productService.getProductList(nameFilter).get(5, TimeUnit.SECONDS);
    }
}
