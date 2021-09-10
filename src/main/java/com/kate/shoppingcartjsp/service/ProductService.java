package com.kate.shoppingcartjsp.service;

import com.kate.shoppingcartjsp.domain.Product;
import com.kate.shoppingcartjsp.dto.ProductDTO;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    ProductDTO findById(Long id);

    List<ProductDTO> getAll();

    ProductDTO createProduct(Product product);

    String deleteById(Long id);

    ProductDTO updatePrice(Long productId, BigDecimal cost);

    ProductDTO editProduct(Long id);

}
