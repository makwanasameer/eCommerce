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
public class AdminService {
    private final List<Order> orders;
    private final List<DiscountCode> discountCodes;

    @Autowired
    public AdminService(List<Order> orders, List<DiscountCode> discountCodes) {
        this.orders = orders;
        this.discountCodes = discountCodes;
    }

    public String generateDiscountCode() {
        DiscountCode code = new DiscountCode();
        code.setCode(UUID.randomUUID().toString());
        code.setUsed(false);
        discountCodes.add(code);
        return code.getCode();
    }

    public AdminSummary getSummary() {
        int itemCount = orders.stream().mapToInt(order -> order.getItems().size()).sum();
        double totalPurchaseAmount = orders.stream().mapToDouble(Order::getTotalAmount).sum();
        double totalDiscountAmount = orders.stream().mapToDouble(Order::getDiscountAmount).sum();

        AdminSummary summary = new AdminSummary();
        summary.setItemCount(itemCount);
        summary.setTotalPurchaseAmount(totalPurchaseAmount);
        summary.setDiscountCodes(discountCodes);
        summary.setTotalDiscountAmount(totalDiscountAmount);

        return summary;
    }
}


