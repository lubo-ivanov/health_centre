package projects.healthcentre.service;


import projects.healthcentre.model.dto.MealWithProductsAndTotalCaloriesDto;

public interface MealService {
    MealWithProductsAndTotalCaloriesDto getMealAndProductsById(Long id);
}
