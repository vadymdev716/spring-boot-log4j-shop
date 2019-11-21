package com.example.shop.product.filter;

import com.example.shop.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductFilter {

    List<Product> nameRegularExpressionFilter(List<Product> products, String regularExpression);
}
