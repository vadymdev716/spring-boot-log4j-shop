package com.example.shop.encoding.decoding;

import org.springframework.stereotype.Component;
import java.util.Base64;

@Component
public class RegExpressionEncodingImpl implements RegExpressionEncoding {

    @Override
    public String encode(String expression){
        return Base64.getEncoder().encodeToString(expression.getBytes());
    }
}
