package com.kate.shoppingcartjsp.service;

import com.kate.shoppingcartjsp.domain.Cart;

import java.io.IOException;
import java.util.List;

public interface CartService {

    Cart createCart(Long customerId) throws IOException;

    List<Cart> getAllCarts();

    Cart addProductsToCart(Long cartId, Long productId, Integer amount);

    Cart updateProductsFromCart(Long cartId, Long productId, Integer amount);

    Cart deleteProductFromCart(Long cartId, Long productId);

    Cart deleteAllProductsFromCart(Long cartId);

    List<Cart> getAllByCustomerId(Long customerId);

}
