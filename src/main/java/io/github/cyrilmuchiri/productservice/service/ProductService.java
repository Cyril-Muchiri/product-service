package io.github.cyrilmuchiri.productservice.service;

import java.util.List;

import io.github.cyrilmuchiri.productservice.model.ProductCreateRequest;
import io.github.cyrilmuchiri.productservice.model.ProductCreateResponse;

public interface ProductService {

    ProductCreateResponse createProduct(ProductCreateRequest request);

    List<ProductCreateResponse> findAll();
    
}
