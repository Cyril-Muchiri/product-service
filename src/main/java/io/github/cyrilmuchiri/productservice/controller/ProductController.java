package io.github.cyrilmuchiri.productservice.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.cyrilmuchiri.productservice.entity.Product;
import io.github.cyrilmuchiri.productservice.model.GenericResponse;
import io.github.cyrilmuchiri.productservice.model.ProductCreateRequest;
import io.github.cyrilmuchiri.productservice.model.ProductCreateResponse;
import io.github.cyrilmuchiri.productservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/products")
@Slf4j

public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public GenericResponse<List<ProductCreateResponse>> getProducts() {
       List< ProductCreateResponse> pr =productService.findAll();
        GenericResponse<List<ProductCreateResponse>>  resp = GenericResponse.<List<ProductCreateResponse>>builder()
        .success(true)
        .msg("Data retrieved successfully")
        .data(pr)
        .build();
        log.info("Returned:{} ", pr);

        return resp;
    }

    @PostMapping("add")
    public GenericResponse<ProductCreateResponse> postProduct(@RequestBody ProductCreateRequest request) {

        log.info("Recieved:{} ",request);

        ProductCreateResponse pr =productService.createProduct(request);
        GenericResponse<ProductCreateResponse> resp = GenericResponse.<ProductCreateResponse>builder()
        .success(true)
        .msg("Data saved successfully")
        .data(pr)
        .build();
        log.info("Returned:{} ", pr);

        return resp;
    }
}
