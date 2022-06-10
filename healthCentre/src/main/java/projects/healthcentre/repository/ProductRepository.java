package projects.healthcentre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import projects.healthcentre.model.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT p FROM Product p JOIN MealProducts mp JOIN Meal m WHERE m.id = :id")
    List<Product> findAllProductsByMealId(Long id);

    Product findProductByName(String name);
}
