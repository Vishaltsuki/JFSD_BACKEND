package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")  // Allow requests from frontend
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Admin Registration
    @PostMapping("/adminregister")
    public Admin registerAdmin(@RequestBody Admin admin) {
        return adminService.registerAdmin(admin);
    }

    // Admin Login
    @PostMapping("/adminlogin")
    public Map<String, Object> loginAdmin(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");
        Map<String, Object> response = new HashMap<>();

        Optional<Admin> admin = adminService.findByUsername(username);
        if (admin.isPresent() && admin.get().getPassword().equals(password)) {
            response.put("success", true);
            response.put("message", "Login successful");
        } else {
            response.put("success", false);
            response.put("message", "Invalid credentials");
        }
        return response;
    }
}
