package projects.healthcentre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projects.healthcentre.model.entity.Meal;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
}
