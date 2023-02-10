package com.aloyolaa.resourceserver.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "customer", uniqueConstraints = {
        @UniqueConstraint(name = "uc_customer_email", columnNames = {"email"})
})
public class Customer extends BaseEntity {
    @NotBlank
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Email
    @NotBlank
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Instant createDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date")
    private Instant updateDate;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Invoice> invoices = new ArrayList<>();
}