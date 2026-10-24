package ma.ensa.gestionpharmacie.repository;

import ma.ensa.gestionpharmacie.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository
        extends JpaRepository<Tag, Long> {
}