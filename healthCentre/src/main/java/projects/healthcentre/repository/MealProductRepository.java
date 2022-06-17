package projects.healthcentre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projects.healthcentre.model.entity.MealProducts;

@Repository
public interface MealProductRepository extends JpaRepository<MealProducts, Long> {

}
