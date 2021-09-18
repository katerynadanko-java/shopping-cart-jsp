package com.kate.shoppingcartjsp.converter;

import com.kate.shoppingcartjsp.domain.Cart;
import com.kate.shoppingcartjsp.dto.CartDTO;

public class CartConverter {
    public static CartDTO convertToCartDto(Cart cart) {
        CartDTO newCart = new CartDTO();
        newCart.setId(cart.getId());
        newCart.setSum(cart.getSum());
        newCart.setProducts(cart.getProducts());
        newCart.setAmount(cart.getAmount());

        return newCart;
    }

    public static Cart convertToCart(CartDTO cartDto) {
        Cart newCart = new Cart();
        newCart.setId(cartDto.getId());
        newCart.setSum(cartDto.getSum());
        newCart.setProducts(cartDto.getProducts());
        newCart.setAmount(cartDto.getAmount());

        return newCart;
    }
}
