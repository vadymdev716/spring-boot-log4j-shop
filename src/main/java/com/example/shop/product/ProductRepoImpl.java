package com.example.shop.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepoImpl implements ProductRepo {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private ProductMapper productMapper;

    @Autowired
    public ProductRepoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate, ProductMapper productMapper) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.productMapper = productMapper;
    }


    @Override
    public List<Product> getProducts() {
        String sql = "SELECT * FROM products";
        return namedParameterJdbcTemplate.query(sql, productMapper);
    }

}
