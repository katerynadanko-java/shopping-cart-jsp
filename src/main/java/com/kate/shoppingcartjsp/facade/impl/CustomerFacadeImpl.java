package com.kate.shoppingcartjsp.facade.impl;

import com.kate.shoppingcartjsp.domain.Customer;
import com.kate.shoppingcartjsp.dto.CustomerDTO;
import com.kate.shoppingcartjsp.facade.CustomerFacade;
import com.kate.shoppingcartjsp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.kate.shoppingcartjsp.converter.CustomerConverter.convertToCustomerDto;

@Service
public class CustomerFacadeImpl implements CustomerFacade {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public void createOrUpdateCustomer(Customer customer) {
        customerRepository.save(customer);
    }
    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> list = customerRepository.findAll();
        return list.stream()
                .map(CustomerDTO::new)
                .collect(Collectors.toCollection(ArrayList::new));
    }
    @Override
    public CustomerDTO editCustomer(Long id) {
        Customer emp = customerRepository.getOne(id);
        return convertToCustomerDto(emp);
    }
}
