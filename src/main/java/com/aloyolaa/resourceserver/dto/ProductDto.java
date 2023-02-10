package com.aloyolaa.resourceserver.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link com.aloyolaa.dtos.entities.Product} entity
 */
public record ProductDto(Long id, @NotBlank String name, @NotNull Double price,
                         Instant createDate) implements Serializable {
}