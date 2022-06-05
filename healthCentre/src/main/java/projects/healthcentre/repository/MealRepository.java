package projects.healthcentre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import projects.healthcentre.model.entity.Meal;
import projects.healthcentre.model.entity.Product;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
    Meal getMealById(Long id);

}
