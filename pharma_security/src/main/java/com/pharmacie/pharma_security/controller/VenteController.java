package com.pharmacie.pharma_security.controller;

import com.pharmacie.pharma_security.model.Medicament;
import com.pharmacie.pharma_security.repository.MedicamentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VenteController {

    private final MedicamentRepository medicamentRepository;

    public VenteController(MedicamentRepository medicamentRepository) {
        this.medicamentRepository = medicamentRepository;
    }

    @GetMapping("/ventes")
    public String ventes(Model model) {
        model.addAttribute("medicaments", medicamentRepository.findAll());
        return "ventes";
    }

    @PostMapping("/ventes/vendre/{id}")
    public String vendre(@PathVariable Long id) {
        Medicament m = medicamentRepository.findById(id).orElseThrow();
        if (m.getQuantite() > 0) {
            m.setQuantite(m.getQuantite() - 1);
            medicamentRepository.save(m);
        }
        return "redirect:/ventes";
    }
}