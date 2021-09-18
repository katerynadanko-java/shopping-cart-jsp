package com.kate.shoppingcartjsp.service.impl;

import com.kate.shoppingcartjsp.domain.Cart;
import com.kate.shoppingcartjsp.domain.Customer;
import com.kate.shoppingcartjsp.domain.Product;
import com.kate.shoppingcartjsp.repository.CartRepository;
import com.kate.shoppingcartjsp.repository.CustomerRepository;
import com.kate.shoppingcartjsp.repository.ProductRepository;
import com.kate.shoppingcartjsp.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    List<Product> products = new ArrayList<>();
    List<Cart> carts = new ArrayList<>();

    @Override
    public Cart createCart(Long customerId) throws IOException {

        if (!customerRepository.existsById(customerId)) {
            throw new IOException("Person with id " + customerId + " does not exists.");
        }
        Cart cart = new Cart();
        Customer customer = customerRepository.findById(customerId).get();
        Cart savedCart = cartRepository.save(cart);
        carts.add(cart);

        customer.setCarts(carts);
        customerRepository.save(customer);
        return savedCart;
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public Cart addProductsToCart(Long cartId, Long productId, Integer amount) {

        Product product = productRepository.getById(productId);
        Optional<Cart> cartOptional = cartRepository.findById(cartId);
        Cart cart = cartOptional.get();
        cart.setAmount(amount);
        products.add(product);
        cart.setProducts(products);
        BigDecimal bigDecimalSum = countSum(cart);
        cart.setSum(bigDecimalSum);
        return cartRepository.save(cart);
    }

    @Override
    public Cart updateProductsFromCart(Long cartId, Long productId, Integer amount) {
        if (!cartRepository.existsById(cartId)) {
            throw new RuntimeException("Cart with id " + cartId + " does not exists");
        }
        if (productId == null) {
            throw new RuntimeException("Required parameters: productId");
        }
        Cart cart = cartRepository.getById(cartId);
        for (Product p : cart.getProducts()) {
            if (productId.equals(p.getId())) {
                cart.setAmount(amount);
                BigDecimal bigDecimalSum = countSum(cart);
                cart.setSum(bigDecimalSum);
                cartRepository.save(cart);
                break;
            }
        }
        return cartRepository.save(cart);
    }

    @Override
    public Cart deleteProductFromCart(Long cartId, Long productId) {
        if (!cartRepository.existsById(cartId)) {
            throw new RuntimeException("Cart with id " + cartId + " does not exists");
        }
        if (productId == null) {
            throw new RuntimeException("Required parameters: productId");
        }
        Cart cart = cartRepository.getById(cartId);
        for (Product p : cart.getProducts()) {
            if (productId.equals(p.getId())) {
                cart.setAmount((cart.getAmount()) - 1);
                BigDecimal bigDecimalSum = countSum(cart);
                cart.setSum(bigDecimalSum);
                cartRepository.save(cart);
                break;
            }
        }
        return cartRepository.save(cart);
    }

    @Override
    public Cart deleteAllProductsFromCart(Long cartId) {
        Cart cart = cartRepository.getById(cartId);
        cart.getProducts().clear();
        BigDecimal bigDecimalSum = BigDecimal.ZERO;
        cart.setSum(bigDecimalSum);
        return cartRepository.save(cart);
    }

    @Override
    public List<Cart> getAllByCustomerId(Long customerId) {
        return customerRepository.getById(customerId).getCarts();
    }

    public BigDecimal countSum(Cart cart) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Product p : cart.getProducts()) {
            sum = sum.add(p.getPrice().multiply(BigDecimal.valueOf(cart.getAmount())));
        }
        cart.setSum(sum);
        return sum;
    }

}

