package com.kate.shoppingcartjsp.dto;

import com.kate.shoppingcartjsp.domain.Product;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
//    private Integer amount;

    public ProductDTO() {

    }

    public ProductDTO(Product product) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
//        this.amount = amount;
    }

}
