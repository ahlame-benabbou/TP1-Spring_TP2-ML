package com.pharmacie.pharma_security.controller;

import com.pharmacie.pharma_security.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    private final UserRepository userRepository;

    public AdminController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "admin";
    }
}