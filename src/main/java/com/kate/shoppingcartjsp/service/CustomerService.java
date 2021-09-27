package com.kate.shoppingcartjsp.service;

import com.kate.shoppingcartjsp.domain.Customer;

import java.util.List;

public interface CustomerService {

    Customer getById(Long id);

    List<Customer> getAllCustomers();

    void deleteCustomer(Long id);

    Customer editCustomer(Long id);


}
