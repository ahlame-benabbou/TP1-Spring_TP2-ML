package ma.ensa.gestionpharmacie.repository;

import ma.ensa.gestionpharmacie.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository
        extends JpaRepository<Produit, Long> {
}