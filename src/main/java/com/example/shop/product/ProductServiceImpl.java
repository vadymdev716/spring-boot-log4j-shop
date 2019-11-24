package com.example.shop.product;

import com.example.shop.encoding.decoding.RegExpressionDecoding;
import com.example.shop.product.filter.ProductFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepo productRepo;
    private ProductFilter productFilter;
    private RegExpressionDecoding regExpressionDecoding;
    private ProductValidation productValidation;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo, ProductFilter productFilter,
                              RegExpressionDecoding regExpressionDecoding, ProductValidation productValidation) {
        this.productRepo = productRepo;
        this.productFilter = productFilter;
        this.regExpressionDecoding = regExpressionDecoding;
        this.productValidation = productValidation;
    }

    @Async
    @Override
    public CompletableFuture<List<Product>> getProductList(String filterCondition) {
        productValidation.checkLength(filterCondition);

        String filter = regExpressionDecoding.decode(filterCondition);
        List<Product> products = productRepo.getProducts();
        List<Product> filteredProducts = productFilter.nameRegularExpressionFilter(products, filter);

        productValidation.listNotEmpty(filteredProducts, filterCondition);
        return CompletableFuture.completedFuture(filteredProducts);
    }
}
