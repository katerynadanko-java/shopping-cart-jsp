package com.kate.shoppingcartjsp.dto;

import com.kate.shoppingcartjsp.domain.Cart;
import com.kate.shoppingcartjsp.domain.Product;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CartDTO {
    private Long id;
    private BigDecimal sum = BigDecimal.ZERO;
    private List<Product> products;

    public CartDTO() {
    }

    public CartDTO(Long id, BigDecimal sum, List<Product> products) {
        this.id = id;
        this.sum = sum;
        this.products = products;
    }

}
