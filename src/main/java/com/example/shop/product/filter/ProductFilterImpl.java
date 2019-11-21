package com.example.shop.product.filter;

import com.example.shop.product.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductFilterImpl implements ProductFilter{

    @Override
    public List<Product> nameRegularExpressionFilter(List<Product> products, String regularExpression) {
        List<Product> filteredProducts = new ArrayList<>();
        for(Product product : products){
            if (product.getDescription().matches(regularExpression)){
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }
}
