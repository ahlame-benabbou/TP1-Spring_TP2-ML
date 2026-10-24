package ma.ensa.gestionpharmacie.repository;

import ma.ensa.gestionpharmacie.entity.DetailProduit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailProduitRepository
        extends JpaRepository<DetailProduit, Long> {
}