package com.aloyolaa.resourceserver.mapper;

import com.aloyolaa.resourceserver.dto.CustomerDetailDto;
import com.aloyolaa.resourceserver.dto.CustomerDto;
import com.aloyolaa.resourceserver.entity.Customer;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CustomerMapper {
    Customer toEntity(CustomerDto customerDto);

    CustomerDto toCustomerDto(Customer customer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer partialUpdate(CustomerDto customerDto, @MappingTarget Customer customer);

    Customer toEntity(CustomerDetailDto customerDetailDto);

    CustomerDetailDto toCustomerDetailDto(Customer customer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer partialUpdate1(CustomerDetailDto customerDetailDto, @MappingTarget Customer customer);

    @AfterMapping
    default void linkInvoices(@MappingTarget Customer customer) {
        customer.getInvoices().forEach(invoice -> invoice.setCustomer(customer));
    }
}