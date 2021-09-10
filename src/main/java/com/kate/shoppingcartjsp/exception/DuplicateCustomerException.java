package com.kate.shoppingcartjsp.exception;

import com.kate.shoppingcartjsp.domain.Customer;
import lombok.Data;

@Data
public class DuplicateCustomerException extends RuntimeException {
    private final Customer customer;

    public DuplicateCustomerException(Customer customer) {
        this.customer = customer;
    }
}