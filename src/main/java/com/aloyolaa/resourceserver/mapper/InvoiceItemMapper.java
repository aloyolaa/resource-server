package com.aloyolaa.resourceserver.mapper;

import com.aloyolaa.resourceserver.dto.InvoiceItemDetailDto;
import com.aloyolaa.resourceserver.dto.InvoiceItemDto;
import com.aloyolaa.resourceserver.entity.InvoiceItem;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {ProductMapper.class})
public interface InvoiceItemMapper {
    @Mapping(source = "productId", target = "product.id")
    InvoiceItem toEntity(InvoiceItemDto invoiceItemDto);

    @Mapping(source = "product.id", target = "productId")
    InvoiceItemDto toInvoiceItemDto(InvoiceItem invoiceItem);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "productId", target = "product.id")
    InvoiceItem partialUpdate(InvoiceItemDto invoiceItemDto, @MappingTarget InvoiceItem invoiceItem);

    InvoiceItem toEntity(InvoiceItemDetailDto invoiceItemDetailDto);

    InvoiceItemDetailDto toInvoiceItemDetailDto(InvoiceItem invoiceItem);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    InvoiceItem partialUpdate1(InvoiceItemDetailDto invoiceItemDetailDto, @MappingTarget InvoiceItem invoiceItem);
}