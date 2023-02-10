package com.aloyolaa.resourceserver.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "invoice_item")
public class InvoiceItem extends BaseEntity {
    @Min(1)
    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public Double getAmount() {
        return this.quantity * this.product.getPrice();
    }
}