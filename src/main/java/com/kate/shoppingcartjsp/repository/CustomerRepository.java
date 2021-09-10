package com.kate.shoppingcartjsp.repository;

import com.kate.shoppingcartjsp.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
