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

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

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
        mealWithProducts.setMealType(meal.getMealType());
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

    @Override
    public Set<MealWithProductsAndTotalCaloriesDto> offerMealPlan(Double requestedCalories) {
        Set<MealWithProductsAndTotalCaloriesDto> mealPlan = new LinkedHashSet<>();
        getMeal(0D, requestedCalories * 0.3, mealPlan, "breakfast");
        getMeal(0D, requestedCalories * 0.4, mealPlan, "lunch");
        getMeal(0D, requestedCalories * 0.3, mealPlan, "dinner");
        return mealPlan;
    }

    private void getMeal(double coefficient, Double requestedCaloriesForMeal, Set<MealWithProductsAndTotalCaloriesDto> mealPlan, String mealType) {
        double finalCoefficient = coefficient + 0.5;
        List<MealWithProductsAndTotalCaloriesDto> meals = getAllMeals()
                .getAllMeals()
                .stream()
                .filter(m -> m.getMealType().toString().equalsIgnoreCase(mealType))
                .filter(m -> m.getTotalCalories() <= requestedCaloriesForMeal * (1 + finalCoefficient)
                             && m.getTotalCalories() >= requestedCaloriesForMeal * (1 - finalCoefficient))
                .toList();
        if (!meals.isEmpty()) {
            int randomIndex = ThreadLocalRandom.current().nextInt(0, meals.size());
            mealPlan.add(meals.get(randomIndex));
        } else {
            getMeal(finalCoefficient, requestedCaloriesForMeal, mealPlan, mealType);
        }
    }


}
