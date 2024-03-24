package io.github.cyrilmuchiri.productservice.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import io.github.cyrilmuchiri.productservice.entity.Product;
import io.github.cyrilmuchiri.productservice.model.ProductCreateRequest;
import io.github.cyrilmuchiri.productservice.model.ProductCreateResponse;
import io.github.cyrilmuchiri.productservice.repository.ProductRepo;
import io.github.cyrilmuchiri.productservice.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo repo;

    public ProductServiceImpl(ProductRepo repo) {
        this.repo = repo;
    }

    @Override
    public ProductCreateResponse createProduct(ProductCreateRequest request) {
        var savedProduct = repo.save(mapToProductEntity(request));
        return mapToProductCreateResponse(savedProduct);

    }

    private Product mapToProductEntity(ProductCreateRequest source) {
        Product target = new Product();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    private ProductCreateResponse mapToProductCreateResponse(Product source) {
        ProductCreateResponse target = new ProductCreateResponse();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    @Override
    public List<ProductCreateResponse> findAll() {
        return repo.findAll().stream().map(this::mapToProductCreateResponse).toList();
    }

}
