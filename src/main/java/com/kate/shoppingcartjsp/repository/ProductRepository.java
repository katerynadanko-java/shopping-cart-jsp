package com.kate.shoppingcartjsp.repository;

import com.kate.shoppingcartjsp.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
