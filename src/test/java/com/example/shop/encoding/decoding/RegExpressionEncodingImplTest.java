package com.example.shop.encoding.decoding;

import com.example.shop.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RegExpressionEncodingImplTest {
    @Autowired
    RegExpressionEncoding regExpressionEncoding;

    @Test
    public void encode_valid_test() {
        assertEquals("Xi4qW2V2YV0uKiQ=", regExpressionEncoding.encode("^.*[eva].*$"));
    }
}
