
package ma .ensaf.exercice_chapitre2.repository;

import ma.ensaf.exercice_chapitre2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface ProductRepository
        extends JpaRepository<Product, Long> {

    // 1. Or
    List<Product> findByNameOrCategory(
            String name, String category);

    // 2. Between
    List<Product> findByPriceBetween(
            double min, double max);

    // 3. Like
    List<Product> findByNameLike(String pattern);

    // 4. IsNull
    List<Product> findByCategoryIsNull();

    // 5. StartingWith
    List<Product> findByNameStartingWith(String prefix);

    // 6. EndingWith
    List<Product> findByNameEndingWith(String suffix);

    // 7. Containing
    List<Product> findByNameContaining(String text);

    // 8. IgnoreCase
    List<Product> findByNameIgnoreCase(String name);

    // 9. After : date postérieure
    List<Product> findByCreatedAtAfter(LocalDate date);

    // 10. Before : date antérieure
    List<Product> findByCreatedAtBefore(LocalDate date);

    // 11. OrderBy
    List<Product> findAllByOrderByPriceAsc();

    // 12. Not
    List<Product> findByCategoryNot(String category);

    // 13. In
    List<Product> findByCategoryIn(List<String> categories);

    // 14. NotIn
    List<Product> findByCategoryNotIn(
            List<String> categories);
}
