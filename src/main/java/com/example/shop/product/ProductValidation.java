package com.example.shop.product;

import com.example.shop.exception.IncorrectLength;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

@Log4j
@Component
public class ProductValidation {

    public void checkLength(String filterCondition) {
        if (filterCondition.length() == 0) {
            log.error(String.format("Incorrect entered parameter length (filterCondition='%s')!", filterCondition));
            throw new IncorrectLength("Incorrect entered parameter length!");
        }
    }
}
