package projects.healthcentre.model.dto;

import projects.healthcentre.model.entity.Product;
import projects.healthcentre.model.enums.MealType;

import java.util.ArrayList;
import java.util.List;

public class MealWithProductsAndTotalCaloriesDto {
    private String name;
    private List<Product> products;
    private Integer totalCalories;
    private MealType mealType;

    public MealWithProductsAndTotalCaloriesDto() {
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Integer getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(Integer totalCalories) {
        this.totalCalories = totalCalories;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }
}
