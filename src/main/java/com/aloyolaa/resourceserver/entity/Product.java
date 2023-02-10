package com.aloyolaa.resourceserver.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "product", indexes = {
        @Index(name = "idx_product_name", columnList = "name")
}, uniqueConstraints = {
        @UniqueConstraint(name = "uc_product_name", columnNames = {"name"})
})
public class Product extends BaseEntity {
    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "create_date")
    private Instant createDate;

    @PrePersist
    public void prePersist() {
        this.createDate = Instant.now();
    }
}