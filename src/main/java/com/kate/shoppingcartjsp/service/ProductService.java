package com.kate.shoppingcartjsp.service;

import com.kate.shoppingcartjsp.domain.Product;
import com.kate.shoppingcartjsp.dto.ProductDTO;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    Product findById(Long id);

    List<Product> getAll();

    Product createProduct(Product product);

    String deleteById(Long id);

    Product updatePrice(Long productId, BigDecimal cost);

    Product editProduct(Long id);

}
