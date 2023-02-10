package com.aloyolaa.resourceserver.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

/**
 * A DTO for the {@link com.aloyolaa.dtos.entities.Customer} entity
 */
public record CustomerDto(Long id, @NotBlank String firstName, @NotBlank String lastName, @Email @NotBlank String email,
                          @NotNull LocalDate birthDate, Instant createDate, Instant updateDate) implements Serializable {
}