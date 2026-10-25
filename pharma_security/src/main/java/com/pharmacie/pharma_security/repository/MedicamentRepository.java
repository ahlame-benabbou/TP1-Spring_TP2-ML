package com.pharmacie.pharma_security.repository;

import com.pharmacie.pharma_security.model.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentRepository extends JpaRepository<Medicament, Long> {
}