package com.aloyolaa.resourceserver.mapper;

import com.aloyolaa.resourceserver.dto.InvoiceDetailDto;
import com.aloyolaa.resourceserver.dto.InvoiceDto;
import com.aloyolaa.resourceserver.entity.Invoice;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {InvoiceItemMapper.class, CustomerMapper.class})
public interface InvoiceMapper {
    @Mapping(source = "customerId", target = "customer.id")
    Invoice toEntity(InvoiceDto invoiceDto);

    @Mapping(source = "customer.id", target = "customerId")
    InvoiceDto toItemDto(Invoice invoice);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "customerId", target = "customer.id")
    Invoice partialUpdate(InvoiceDto invoiceDto, @MappingTarget Invoice invoice);

    Invoice toEntity(InvoiceDetailDto invoiceDetailDto);

    InvoiceDetailDto toInvoiceDetailDto(Invoice invoice);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Invoice partialUpdate1(InvoiceDetailDto invoiceDetailDto, @MappingTarget Invoice invoice);
}