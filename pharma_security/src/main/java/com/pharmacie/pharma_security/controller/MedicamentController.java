package com.pharmacie.pharma_security.controller;

import com.pharmacie.pharma_security.repository.MedicamentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/medicaments")
public class MedicamentController {

    private final MedicamentRepository medicamentRepository;

    public MedicamentController(MedicamentRepository medicamentRepository) {
        this.medicamentRepository = medicamentRepository;
    }

    @GetMapping
    public String listerMedicaments(Model model) {
        model.addAttribute("medicaments", medicamentRepository.findAll());
        return "medicaments";
    }
}