package com.aloyolaa.resourceserver.controller;

import com.aloyolaa.resourceserver.dto.ProductDto;
import com.aloyolaa.resourceserver.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> getAll() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getOne(@PathVariable Long id) {
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productService.save(productDto), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ProductDto> update(@RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productService.update(productDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return new ResponseEntity<>(productService.delete(id), HttpStatus.OK);
    }
}
