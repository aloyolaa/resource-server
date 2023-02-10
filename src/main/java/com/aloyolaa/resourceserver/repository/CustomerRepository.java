package com.aloyolaa.resourceserver.repository;

import com.aloyolaa.resourceserver.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}