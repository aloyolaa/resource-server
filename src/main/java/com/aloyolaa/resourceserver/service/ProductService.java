package com.aloyolaa.resourceserver.service;

import com.aloyolaa.resourceserver.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();

    ProductDto findById(Long id);

    ProductDto save(ProductDto productDto);

    ProductDto update(ProductDto productDto);

    Boolean delete(Long id);
}
