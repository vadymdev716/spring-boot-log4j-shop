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
public class RegExpressionDecodingImplTest {
    @Autowired
    RegExpressionDecoding regExpressionDecoding;

    @Test
    public void decode_valid_test() {
        assertEquals("^E.*$", regExpressionDecoding.decode("XkUuKiQ="));
    }

    @Test(expected = IllegalArgumentException.class)
    public void decode_not_valid_filter_param_numeral_test() {
        regExpressionDecoding.decode("1");
    }
}
