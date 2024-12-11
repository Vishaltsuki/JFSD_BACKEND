package com.example.demo.service;

import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // Register Admin
    public Admin registerAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    // Find Admin by Username for Login
    public Optional<Admin> findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }
}
