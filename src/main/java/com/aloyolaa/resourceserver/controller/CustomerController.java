package com.aloyolaa.resourceserver.controller;

import com.aloyolaa.resourceserver.dto.CustomerDetailDto;
import com.aloyolaa.resourceserver.dto.CustomerDto;
import com.aloyolaa.resourceserver.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/")
    public ResponseEntity<List<CustomerDto>> getAll() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDetailDto> getOne(@PathVariable Long id) {
        return new ResponseEntity<>(customerService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<CustomerDto> save(@RequestBody CustomerDto customerDto) {
        return new ResponseEntity<>(customerService.save(customerDto), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<CustomerDto> update(@RequestBody CustomerDto customerDto) {
        return new ResponseEntity<>(customerService.update(customerDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return new ResponseEntity<>(customerService.delete(id), HttpStatus.OK);
    }
}
