package com.kate.shoppingcartjsp.service.impl;

import com.kate.shoppingcartjsp.domain.Customer;
import com.kate.shoppingcartjsp.repository.CustomerRepository;
import com.kate.shoppingcartjsp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getById(Long id) {
        return customerRepository.getById(id);
    }

    public List<Customer> getAllCustomers() {
        List<Customer> list = customerRepository.findAll();
        return list;
    }
    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
    @Override
    public Customer editCustomer(Long id) {
        Customer emp = customerRepository.getOne(id);
        return emp;
    }
}








//
//    @Autowired
//    private CustomerRepository customerRepository;
//    @Override
//    public void createOrUpdateCustomer(Customer customer) {
//        customerRepository.save(customer);
//    }
//
//    @Override
//    public Customer getById(Long id) {
//        return customerRepository.getById(id);
//    }
//
//    public List<CustomerDTO> getAllCustomers() {
//        List<Customer> list = customerRepository.findAll();
//        return list.stream()
//                .map(CustomerDTO::new)
//                .collect(Collectors.toCollection(ArrayList::new));
//    }
//    @Override
//    public void deleteCustomer(Long id) {
//        customerRepository.deleteById(id);
//    }
//    @Override
//    public CustomerDTO editCustomer(Long id) {
//        Customer emp = customerRepository.getOne(id);
//        return convertToCustomerDto(emp);
//    }
