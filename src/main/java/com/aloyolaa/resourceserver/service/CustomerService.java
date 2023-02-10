package com.aloyolaa.resourceserver.service;

import com.aloyolaa.resourceserver.dto.CustomerDetailDto;
import com.aloyolaa.resourceserver.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> findAll();

    CustomerDetailDto findById(Long id);

    CustomerDto save(CustomerDto customerDto);

    CustomerDto update(CustomerDto customerDto);

    Boolean delete(Long id);
}
