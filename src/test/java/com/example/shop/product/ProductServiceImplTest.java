package com.example.shop.product;

import com.example.shop.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ProductServiceImplTest {
    @Autowired
    ProductService productService;

    @Test
    public void getProductList_valid_test() {
        CompletableFuture<List<Product>> products = productService.getProductList("Xi4qW2V2YV0uKiQ=");

        try {
            assertEquals(initTestProductList(), products.get(5, TimeUnit.SECONDS));
        } catch (ExecutionException | InterruptedException | TimeoutException e) {
            fail("No Exception expected");
        }
    }

    private List<Product> initTestProductList(){
        List<Product> products = Arrays.asList(new Product(5, "Tom 5", "description 5"),
                new Product(6, "Tom 6", "description 6"),
                new Product(7, "nic 7", "description 7"),
                new Product(8, "nic 8", "description 8"));
        return products;
    }
}
