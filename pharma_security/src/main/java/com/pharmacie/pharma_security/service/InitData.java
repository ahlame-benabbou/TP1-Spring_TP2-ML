package com.pharmacie.pharma_security.service;

import com.pharmacie.pharma_security.model.*;
import com.pharmacie.pharma_security.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class InitData implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final MedicamentRepository medicamentRepository;
    private final PasswordEncoder passwordEncoder;

    public InitData(UserRepository userRepository, RoleRepository roleRepository,
                    MedicamentRepository medicamentRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.medicamentRepository = medicamentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        Role admin = role("ADMIN");
        Role pharmacien = role("PHARMACIEN");
        Role caissier = role("CAISSIER");
        role("CLIENT");

        user("admin", "admin123", admin);
        user("pharma", "pharma123", pharmacien);
        user("caisse", "caisse123", caissier);

        if (medicamentRepository.count() == 0) {
            medicamentRepository.save(new Medicament("Doliprane 1000mg", 15.5, 100));
            medicamentRepository.save(new Medicament("Amoxicilline 500mg", 32.0, 50));
            medicamentRepository.save(new Medicament("Ibuprofène 400mg", 20.0, 80));
        }
    }

    private Role role(String name) {
        return roleRepository.findByName(name).orElseGet(() -> roleRepository.save(new Role(name)));
    }

    private void user(String username, String rawPassword, Role role) {
        if (userRepository.findByUsername(username).isEmpty()) {
            User u = new User();
            u.setUsername(username);
            u.setPassword(passwordEncoder.encode(rawPassword));
            u.setRoles(Set.of(role));
            userRepository.save(u);
        }
    }
}