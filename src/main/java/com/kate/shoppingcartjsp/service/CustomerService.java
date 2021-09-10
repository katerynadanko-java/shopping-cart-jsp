package com.kate.shoppingcartjsp.service;

import com.kate.shoppingcartjsp.domain.Customer;
import com.kate.shoppingcartjsp.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void createOrUpdateCustomer(Customer customer);

    List<CustomerDTO> getAllCustomers();

    void deleteCustomer(Long id);

    CustomerDTO editCustomer(Long id);

}
