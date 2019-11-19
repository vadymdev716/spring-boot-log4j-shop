package com.example.shop.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    //http://localhost:8080/shop/product?nameFilter=1;
    @GetMapping("/product")
    public List<Product> getProductList(@RequestParam String nameFilter) {
        //return "Hi product";
        //return new ArrayList<Product>();
        return productService.getProductList(nameFilter);
    }
}
