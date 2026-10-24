
package ma.ensaf.exercice_chapitre2;

import ma.ensaf.exercice_chapitre2.entity.Product;
import ma.ensaf.exercice_chapitre2.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner testQueries(ProductRepository repo) {
        return args -> {

            repo.saveAll(List.of(
                new Product("Samsung Galaxy", 8000,
                    "Informatique",
                    LocalDate.of(2025, 1, 10)),

                new Product("iPhone Pro", 12000,
                    "Téléphone",
                    LocalDate.of(2025, 3, 15)),

                new Product("Laptop Lenovo", 9000,
                    "Informatique",
                    LocalDate.of(2025, 5, 20)),

                new Product("Livre Java", 150,
                    "Livre",
                    LocalDate.of(2024, 6, 10)),

                new Product("Casque Pro", 500,
                    null,
                    LocalDate.of(2025, 8, 1))
            ));

            System.out.println("=== TEST DES METHODES JPA ===");

            System.out.println("1. OR : " +
                repo.findByNameOrCategory(
                    "Samsung Galaxy", "Livre"));

            System.out.println("2. BETWEEN : " +
                repo.findByPriceBetween(500, 9000));

            System.out.println("3. LIKE : " +
                repo.findByNameLike("%Pro%"));

            System.out.println("4. IS NULL : " +
                repo.findByCategoryIsNull());

            System.out.println("5. STARTING WITH : " +
                repo.findByNameStartingWith("Samsung"));

            System.out.println("6. ENDING WITH : " +
                repo.findByNameEndingWith("Pro"));

            System.out.println("7. CONTAINING : " +
                repo.findByNameContaining("Java"));

            System.out.println("8. IGNORE CASE : " +
                repo.findByNameIgnoreCase("samsung galaxy"));

            System.out.println("9. AFTER : " +
                repo.findByCreatedAtAfter(
                    LocalDate.of(2025, 3, 1)));

            System.out.println("10. BEFORE : " +
                repo.findByCreatedAtBefore(
                    LocalDate.of(2025, 1, 1)));

            System.out.println("11. ORDER BY : " +
                repo.findAllByOrderByPriceAsc());

            System.out.println("12. NOT : " +
                repo.findByCategoryNot("Livre"));

            System.out.println("13. IN : " +
                repo.findByCategoryIn(
                    List.of("Livre", "Informatique")));

            System.out.println("14. NOT IN : " +
                repo.findByCategoryNotIn(
                    List.of("Livre", "Informatique")));
        };
    }
}
