package projects.healthcentre.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AllMealsDto {
    List<MealWithProductsAndTotalCaloriesDto> allMeals;
    public void addMeal(MealWithProductsAndTotalCaloriesDto meal) {
        this.allMeals.add(meal);
    }
}
