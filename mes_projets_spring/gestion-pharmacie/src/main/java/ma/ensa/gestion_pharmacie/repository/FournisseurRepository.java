package ma.ensa.gestionpharmacie.repository;

import ma.ensa.gestionpharmacie.entity.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository
        extends JpaRepository<Fournisseur, Long> {
}