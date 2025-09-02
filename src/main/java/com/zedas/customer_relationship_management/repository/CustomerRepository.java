package com.zedas.customer_relationship_management.repository;

import com.zedas.customer_relationship_management.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}