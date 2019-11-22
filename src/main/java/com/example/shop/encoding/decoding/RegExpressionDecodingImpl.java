package com.example.shop.encoding.decoding;

import org.springframework.stereotype.Component;
import java.util.Base64;

@Component
public class RegExpressionDecodingImpl implements RegExpressionDecoding {

    @Override
    public String decode(String encodedString){
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        return new String(decodedBytes);
    }
}
