package ma.ensa.gestionpharmacie.repository;

import ma.ensa.gestionpharmacie.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository
        extends JpaRepository<Categorie, Long> {
}