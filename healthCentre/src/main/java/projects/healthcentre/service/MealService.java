package projects.healthcentre.service;


import projects.healthcentre.model.dto.AllMealsDto;
import projects.healthcentre.model.dto.MealWithProductsAndTotalCaloriesDto;

import java.util.Set;

public interface MealService {
    MealWithProductsAndTotalCaloriesDto getMealAndProductsById(Long id);
    AllMealsDto getAllMeals();

    Set<MealWithProductsAndTotalCaloriesDto> offerMealPlan();
}
