package com.kate.shoppingcartjsp.facade;

import com.kate.shoppingcartjsp.domain.Customer;
import com.kate.shoppingcartjsp.dto.CustomerDTO;

import java.util.List;

public interface CustomerFacade {
    void createOrUpdateCustomer(Customer customer);

    List<CustomerDTO> getAllCustomers();

    void deleteCustomer(Long id);

    CustomerDTO editCustomer(Long id);
}
