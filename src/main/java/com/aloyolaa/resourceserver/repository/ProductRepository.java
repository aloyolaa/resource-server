package com.aloyolaa.resourceserver.repository;

import com.aloyolaa.resourceserver.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}