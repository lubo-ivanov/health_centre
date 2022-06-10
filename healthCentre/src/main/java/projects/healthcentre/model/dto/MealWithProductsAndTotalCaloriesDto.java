package projects.healthcentre.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import projects.healthcentre.model.entity.Product;
import projects.healthcentre.model.enums.MealType;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MealWithProductsAndTotalCaloriesDto {
    private String name;
    private List<Product> products;
    private Integer totalCalories;
    private MealType mealType;

}
