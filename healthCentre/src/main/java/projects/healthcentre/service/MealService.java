package projects.healthcentre.service;


import projects.healthcentre.model.dto.AllMealsDto;
import projects.healthcentre.model.dto.CaloriesInputProfileDto;
import projects.healthcentre.model.dto.MealSeedDto;
import projects.healthcentre.model.dto.MealWithProductsAndTotalCaloriesDto;
import projects.healthcentre.model.entity.Meal;

import java.util.Set;

public interface MealService {
    MealWithProductsAndTotalCaloriesDto getMealById(Long id);
    AllMealsDto getAllMeals();
    Set<MealWithProductsAndTotalCaloriesDto> offerMealPlan(CaloriesInputProfileDto caloriesInputProfileDto);

    Meal saveMeal(MealSeedDto mealSeedDto);
}
