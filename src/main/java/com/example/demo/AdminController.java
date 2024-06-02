package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/generate-discount")
    public ResponseEntity<String> generateDiscountCode() {
        String code = adminService.generateDiscountCode();
        return ResponseEntity.ok("Discount code generated: " + code);
    }

    @GetMapping("/summary")
    public ResponseEntity<AdminSummary> getSummary() {
        return ResponseEntity.ok(adminService.getSummary());
    }
}


