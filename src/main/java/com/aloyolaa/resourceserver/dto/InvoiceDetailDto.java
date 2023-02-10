package com.aloyolaa.resourceserver.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * A DTO for the {@link com.aloyolaa.dtos.entities.Invoice} entity
 */
public record InvoiceDetailDto(Long id, @NotBlank String description, String observation, Instant createDate,
                               @NotNull CustomerDto customer,
                               @Size(min = 1) List<InvoiceItemDetailDto> invoiceItems) implements Serializable {
}