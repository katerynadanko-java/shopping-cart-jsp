package com.kate.shoppingcartjsp.facade;

import com.kate.shoppingcartjsp.domain.Product;
import com.kate.shoppingcartjsp.dto.ProductDTO;
import com.kate.shoppingcartjsp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.kate.shoppingcartjsp.converter.ProductConverter.convertToProductDto;

public interface ProductFacade {

    ProductDTO findById(Long id);

    List<ProductDTO> getAll();

    ProductDTO createProduct(Product product);

    ProductDTO updatePrice(Long productId, BigDecimal price);

    ProductDTO editProduct(Long id);
}
