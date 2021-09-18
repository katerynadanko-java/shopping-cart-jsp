package com.kate.shoppingcartjsp.controller;

import com.kate.shoppingcartjsp.domain.Cart;
import com.kate.shoppingcartjsp.service.CartService;
import com.kate.shoppingcartjsp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("api/cart")

public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/registration")
    public String createCart() {
        return "CartRegistration";
    }

    @PostMapping("/home")
    public String createCart(Model model, @ModelAttribute("customerId") Long customerId) throws IOException {
        model.addAttribute("cart", cartService.createCart(customerId));
        return "redirect:api/cart/" + customerId + "/list";
    }

    @GetMapping("{id}/list")
    public String listOfCart(Model model, @PathVariable("id") Long customerId) {
        List<Cart> carts = cartService.getAllByCustomerId(customerId);
        model.addAttribute("carts", carts);
        return "cartList";
    }

    @PostMapping("{id}/delete-product-from-cart")
    public String deleteProductFromCart(Model model,  @PathVariable("id") Long cartId, @ModelAttribute("productId") Long productId) {
        cartService.deleteProductFromCart(cartId, productId);
        model.addAttribute("product", productId);
        return "redirect:api/cart/cartList";
    }

    @GetMapping("{id}/{amount}/add-product")
    public String addProduct(Model model,  @PathVariable("id") Long cartId, @PathVariable("amount") Integer amount, @ModelAttribute("productId") Long productId) {
        cartService.addProductsToCart(cartId, productId, 1);
        model.addAttribute("product", productId);
        return "redirect:/api/cart/list/";
    }

    @PostMapping("/update-cart")
    public String updateCart(Model model, @ModelAttribute("cartId") Long id, @PathVariable("productId") Long productId, @PathVariable("amount") Integer amount) {
        cartService.updateProductsFromCart(id, productId, amount);
        model.addAttribute("cartId", id);
        return "redirect:/api/cart/list/";
    }

    @GetMapping("/empty")
    public String emptyCart(Model model, @ModelAttribute("id") Long cartId) {
        cartService.deleteAllProductsFromCart(cartId);
        model.addAttribute("cartId", cartId);
        return "redirect:/api/cart/list/";
    }
}