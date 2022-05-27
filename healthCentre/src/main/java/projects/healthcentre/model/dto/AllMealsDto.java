package projects.healthcentre.model.dto;

import java.util.ArrayList;
import java.util.List;

public class AllMealsDto {
    List<MealWithProductsAndTotalCaloriesDto> allMeals;

    public AllMealsDto() {
        this.allMeals = new ArrayList<>();
    }

    public List<MealWithProductsAndTotalCaloriesDto> getAllMeals() {
        return allMeals;
    }

    public void setAllMeals(List<MealWithProductsAndTotalCaloriesDto> allMeals) {
        this.allMeals = allMeals;
    }
    public void addMeal(MealWithProductsAndTotalCaloriesDto meal) {
        this.allMeals.add(meal);
    }
}
