package projects.healthcentre.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.healthcentre.model.dto.AllMealsDto;
import projects.healthcentre.model.dto.MealWithProductsAndTotalCaloriesDto;
import projects.healthcentre.model.entity.Meal;
import projects.healthcentre.model.entity.Product;
import projects.healthcentre.repository.MealRepository;
import projects.healthcentre.repository.ProductRepository;
import projects.healthcentre.service.MealService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MealServiceImpl implements MealService {
    private final MealRepository mealRepository;
    private final ProductRepository productRepository;

    @Autowired
    public MealServiceImpl(MealRepository mealRepository, ProductRepository productRepository) {
        this.mealRepository = mealRepository;
        this.productRepository = productRepository;
    }

    @Override
    public MealWithProductsAndTotalCaloriesDto getMealAndProductsById(Long id) {
        MealWithProductsAndTotalCaloriesDto mealWithProducts = new MealWithProductsAndTotalCaloriesDto();
        Meal meal = mealRepository.getMealById(id);
        mealWithProducts.setName(meal.getName());
        List<Product> products = productRepository.findAllProductsByMealId(id);
        mealWithProducts.setProducts(products);
        mealWithProducts.setTotalCalories(products.stream()
                .map(Product::getCalories)
                .mapToInt(Integer::intValue)
                .sum());
        return mealWithProducts;
    }

    @Override
    public AllMealsDto getAllMeals() {
        AllMealsDto allMeals = new AllMealsDto();
        for (long i = 1; i <= mealRepository.count(); i++) {
            allMeals.addMeal(getMealAndProductsById(i));
        }
        return allMeals;
    }
}
