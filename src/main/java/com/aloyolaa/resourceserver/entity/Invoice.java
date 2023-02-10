package com.aloyolaa.resourceserver.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "invoice")
public class Invoice extends BaseEntity {
    @NotBlank
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "observation")
    private String observation;

    @Column(name = "create_date")
    private Instant createDate;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Size(min = 1)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "invoice_id", nullable = false)
    private List<InvoiceItem> invoiceItems = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        this.createDate = Instant.now();
    }

    public Double getTotal() {
        Double total = 0.0;
        for (InvoiceItem invoiceItem: this.invoiceItems) {
            total += invoiceItem.getAmount();
        }
        return total;
    }
}