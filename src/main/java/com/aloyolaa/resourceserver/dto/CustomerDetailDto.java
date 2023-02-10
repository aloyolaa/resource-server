package com.aloyolaa.resourceserver.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

/**
 * A DTO for the {@link com.aloyolaa.dtos.entities.Customer} entity
 */
public record CustomerDetailDto(Long id, @NotBlank String firstName, @NotBlank String lastName,
                                @Email @NotBlank String email, @NotNull LocalDate birthDate, Instant createDate,
                                Instant updateDate, List<InvoiceDataDto> invoices) implements Serializable {
    /**
     * A DTO for the {@link com.aloyolaa.dtos.entities.Invoice} entity
     */
    public record InvoiceDataDto(Long id, @NotBlank String description, String observation, Instant createDate,
                              @Size(min = 1) List<InvoiceItemDetailDto> invoiceItems) implements Serializable {
    }
}