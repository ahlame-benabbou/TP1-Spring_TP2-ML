package ma.ensa.gestionpharmacie.service;

import ma.ensa.gestionpharmacie.entity.Produit;
import ma.ensa.gestionpharmacie.repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    private final ProduitRepository repository;

    public ProduitService(ProduitRepository repository) {
        this.repository = repository;
    }

    public List<Produit> getAll() {
        return repository.findAll();
    }

    public Produit getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Produit introuvable : " + id));
    }

    public Produit save(Produit produit) {
        return repository.save(produit);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}