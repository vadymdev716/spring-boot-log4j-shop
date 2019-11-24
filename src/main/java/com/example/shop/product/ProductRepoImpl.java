package com.example.shop.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepoImpl implements ProductRepo {
    private ProductMapper productMapper;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductRepoImpl(ProductMapper productMapper, JdbcTemplate jdbcTemplate) {
        this.productMapper = productMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> getProducts() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, productMapper);
    }
}
