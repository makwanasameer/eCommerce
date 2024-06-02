package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Service
public class CartService {
    private final List<CartItem> cart = new ArrayList<>();
    private final List<Order> orders = new ArrayList<>();
    private final List<DiscountCode> discountCodes = new ArrayList<>();
    private final int nthOrder = 5;

    public void addToCart(CartItem item) {
        cart.add(item);
    }

    public Order checkout(String discountCode) throws InvalidDiscountCodeException {
        double totalAmount = cart.stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
        boolean discountApplied = false;
        double discountAmount = 0.0;

        if (discountCode != null && !discountCode.isEmpty()) {
            DiscountCode code = discountCodes.stream()
                    .filter(c -> c.getCode().equals(discountCode) && !c.isUsed())
                    .findFirst()
                    .orElseThrow(() -> new InvalidDiscountCodeException("Invalid discount code"));

            discountAmount = totalAmount * 0.1;
            totalAmount -= discountAmount;
            code.setUsed(true);
            discountApplied = true;
        }

        Order order = new Order();
        order.setOrderId(UUID.randomUUID().toString());
        order.setItems(new ArrayList<>(cart));
        order.setTotalAmount(totalAmount);
        order.setDiscountApplied(discountApplied);
        order.setDiscountAmount(discountAmount);

        orders.add(order);
        cart.clear();

        if (orders.size() % nthOrder == 0) {
            generateDiscountCode();
        }

        return order;
    }

    private void generateDiscountCode() {
        DiscountCode code = new DiscountCode();
        code.setCode(UUID.randomUUID().toString());
        code.setUsed(false);
        discountCodes.add(code);
    }
}

