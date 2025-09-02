package com.zedas.customer_relationship_management.service.impl;

import com.zedas.customer_relationship_management.entity.Customer;
import com.zedas.customer_relationship_management.repository.CustomerRepository;
import com.zedas.customer_relationship_management.service.CustomerService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public Customer createCustomer(Customer customer) {
        customer.setCreatedDate(LocalDateTime.now());
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
