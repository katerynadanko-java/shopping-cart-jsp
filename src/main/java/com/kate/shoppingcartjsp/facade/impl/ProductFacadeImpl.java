package com.kate.shoppingcartjsp.facade.impl;

import com.kate.shoppingcartjsp.domain.Product;
import com.kate.shoppingcartjsp.dto.ProductDTO;
import com.kate.shoppingcartjsp.facade.ProductFacade;
import com.kate.shoppingcartjsp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.kate.shoppingcartjsp.converter.ProductConverter.convertToProductDto;
@Service
public class ProductFacadeImpl implements ProductFacade {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDTO findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return convertToProductDto(product.get());
    }

    @Override
    public List<ProductDTO> getAll() {
        List<Product> list = productRepository.findAll();
        return list.stream()
                .map(ProductDTO::new)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public ProductDTO createProduct(Product product) {
        return convertToProductDto(productRepository.save(product));
    }
    @Override
    public String deleteById(Long id) {
        productRepository.deleteById(id);
        return String.valueOf(id);
    }

    @Override
    public ProductDTO updatePrice(Long productId, BigDecimal price) {
        Optional<Product> productRepositoryById = productRepository.findById(productId);
        if (price.compareTo(new BigDecimal(0)) < 0) {
            throw new RuntimeException("Product should not cost less then 0");
        }
        productRepositoryById.get().setPrice(price);
        return convertToProductDto(productRepositoryById.get());
    }

    @Override
    public ProductDTO editProduct(Long id) {
        Product emp = productRepository.getOne(id);
        return convertToProductDto(emp);
    }
}
