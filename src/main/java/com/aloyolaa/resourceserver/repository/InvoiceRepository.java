package com.aloyolaa.resourceserver.repository;

import com.aloyolaa.resourceserver.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}