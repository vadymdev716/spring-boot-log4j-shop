package com.example.shop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
public class Controller {

    //http://localhost:8080/shop/product?nameFilter=1;
    @GetMapping("/product")
    public String getByID(@RequestParam String nameFilter) {
        return "Hi product";
    }
}
