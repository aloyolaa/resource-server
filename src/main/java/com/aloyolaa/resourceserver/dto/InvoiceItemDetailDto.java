package com.aloyolaa.resourceserver.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * A DTO for the {@link com.aloyolaa.dtos.entities.InvoiceItem} entity
 */
public record InvoiceItemDetailDto(Long id, @Min(1) @NotNull Integer quantity,
                                   @NotNull ProductDto product) implements Serializable {
}