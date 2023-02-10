package com.aloyolaa.resourceserver.mapper;

import com.aloyolaa.resourceserver.dto.ProductDto;
import com.aloyolaa.resourceserver.entity.Product;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProductMapper {
    Product toEntity(ProductDto productDto);

    ProductDto toProductDto(Product product);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Product partialUpdate(ProductDto productDto, @MappingTarget Product product);
}