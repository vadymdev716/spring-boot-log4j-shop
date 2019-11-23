package com.example.shop.product;

import com.example.shop.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ProductRepoImplTest {
    @Autowired ProductRepo productRepo;

    @Test
    public void get_products_test() {
        List<Product> productsFroomDB = productRepo.getProducts();
        assertEquals(initTestProductList(),productsFroomDB);
    }

    private List<Product> initTestProductList(){
        List<Product> products = Arrays.asList(new Product(1, "elena 1", "description 1"),
                new Product(2, "elena 2", "description 2"),
                new Product(3, "Elena 3", "description 3"),
                new Product(4, "Elena 4", "description 4"),
                new Product(5, "Tom 5", "description 5"),
                new Product(6, "Tom 6", "description 6"),
                new Product(7, "nic 7", "description 7"),
                new Product(8, "nic 8", "description 8"),
                new Product(9, "Nica 9", "description 9"),
                new Product(10, "Nicv 10", "description 10"),
                new Product(11, "Nice 11", "description 11"));
        return products;
    }
}
