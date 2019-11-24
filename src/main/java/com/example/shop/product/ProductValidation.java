package com.example.shop.product;

import com.example.shop.exception.IncorrectLength;
import com.example.shop.exception.NotFoundException;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Log4j
@Component
public class ProductValidation {

    public void checkLength(String filterCondition) {
        if (filterCondition.length() == 0) {
            log.error(String.format("Incorrect entered parameter length (filterCondition='%s')!", filterCondition));
            throw new IncorrectLength("Incorrect entered parameter length!");
        }
    }

    public void listNotEmpty(List<Product> products, String filterCondition){
        if (products.size() == 0) {
            log.error(String.format("No results found for user filter (that = %s) ", filterCondition));
            throw new NotFoundException("Products with your filter not found!");
        }
    }
}
