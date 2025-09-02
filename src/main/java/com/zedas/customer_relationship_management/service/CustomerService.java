package com.zedas.customer_relationship_management.service;

import com.zedas.customer_relationship_management.entity.Customer;
import java.util.List;

public interface CustomerService {

    Customer createCustomer(Customer customer);

    List<Customer>  getAllCustomers();

    Customer updateCustomer(Long id, Customer customer);

    void deleteCustomer(Long id);
}
