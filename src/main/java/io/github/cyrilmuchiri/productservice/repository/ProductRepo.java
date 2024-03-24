package io.github.cyrilmuchiri.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.cyrilmuchiri.productservice.entity.Product;

public interface ProductRepo extends JpaRepository<Product,Integer> {
    
}
