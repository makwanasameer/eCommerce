package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestBody CartItem item) {
        cartService.addToCart(item);
        return ResponseEntity.ok("Item added to cart");
    }

    @PostMapping("/checkout")
    public ResponseEntity<String> checkout(@RequestParam(required = false) String discountCode) {
        try {
            Order order = cartService.checkout(discountCode);
            return ResponseEntity.ok("Order placed successfully. Order ID: " + order.getOrderId());
        } catch (InvalidDiscountCodeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

