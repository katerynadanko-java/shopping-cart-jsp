package com.kate.shoppingcartjsp.controller;

import com.kate.shoppingcartjsp.domain.Cart;
import com.kate.shoppingcartjsp.dto.CartDTO;
import com.kate.shoppingcartjsp.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("api/cart")

public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/registration")
    public String createCart(Map<String, Object> model) {

        model.put("cartDTO", new CartDTO());

        return "CartRegistration";
    }

    @PostMapping("/home")
    public String createCart(Model model, Long customerId) throws IOException {
        model.addAttribute("cart", cartService.createCart(customerId));
        return "cart";
    }

    @GetMapping("/list")
    public String listOfCart(Model model) {
        List<Cart> cartList = cartService.getAllCarts();
        cartList.stream()
                .map(Cart::new)
                .collect(Collectors.toCollection(ArrayList::new));
        model.addAttribute("cartList", cartList);
        return "cartList";
    }

    @PostMapping("/delete-product-from-cart")
    public String deleteProductFromCart(@RequestParam("id, productId") Long id, Long productId) {
        cartService.deleteProductFromCart(id, productId);
        return "redirect:api/cart/cartList";
    }

    @GetMapping("/add-product")
    public String addProduct(@RequestParam Long id, Long productId) {
        cartService.addProductsToCart(id, productId, 1);
        return "redirect:/api/cart/list/";
    }

    @PostMapping("/update-cart")
    public String updateCart(@ModelAttribute Long id, Long productId,Integer amount) {
        cartService.updateProductsFromCart(id, productId, amount);
        return "redirect:/api/cart/list/";
    }

    @GetMapping("/empty")
    public String emptyCart(Long id) {
        cartService.deleteAllProductsFromCart(id);
        return "redirect:/api/cart/list/";
    }
}