package com.kate.shoppingcartjsp.service.impl;

import com.kate.shoppingcartjsp.domain.Product;
import com.kate.shoppingcartjsp.repository.ProductRepository;
import com.kate.shoppingcartjsp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.get();
    }
    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public String deleteById(Long id) {
        productRepository.deleteById(id);
        return String.valueOf(id);
    }

    @Override
    public Product updatePrice(Long productId, BigDecimal price) {
        Optional<Product> productRepositoryById = productRepository.findById(productId);
        if (price.compareTo(new BigDecimal(0)) < 0) {
            throw new RuntimeException("Product should not cost less then 0");
        }
        productRepositoryById.get().setPrice(price);
        return productRepositoryById.get();
    }
    @Override
    public Product editProduct(Long id) {
        Product emp = productRepository.getOne(id);
        return emp;
    }
}
