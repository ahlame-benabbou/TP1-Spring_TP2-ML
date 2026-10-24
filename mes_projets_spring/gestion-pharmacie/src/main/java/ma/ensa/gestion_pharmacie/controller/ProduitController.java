package ma.ensa.gestionpharmacie.controller;

import ma.ensa.gestionpharmacie.entity.Produit;
import ma.ensa.gestionpharmacie.service.ProduitService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    private final ProduitService service;

    public ProduitController(ProduitService service) {
        this.service = service;
    }

    @GetMapping
    public List<Produit> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Produit getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<Produit> create(
            @RequestBody Produit produit) {
        Produit saved = service.save(produit);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(saved);
    }

    @PutMapping("/{id}")
    public Produit update(
            @PathVariable Long id,
            @RequestBody Produit nouveau) {

        Produit produit = service.getById(id);

        produit.setNom(nouveau.getNom());
        produit.setDescription(nouveau.getDescription());
        produit.setPrix(nouveau.getPrix());
        produit.setCodeBarre(nouveau.getCodeBarre());
        produit.setDateExpiration(nouveau.getDateExpiration());

        produit.setCategorie(nouveau.getCategorie());
        produit.setFournisseur(nouveau.getFournisseur());
        produit.setDetailProduit(nouveau.getDetailProduit());
        produit.setTags(nouveau.getTags());

        return service.save(produit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}