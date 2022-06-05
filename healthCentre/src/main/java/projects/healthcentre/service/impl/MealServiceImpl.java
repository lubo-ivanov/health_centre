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
    /* Get a meal and all of its products by Meal ID */
    public MealWithProductsAndTotalCaloriesDto getMealById(Long id) {
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
    /* Create a list of all meals and their products */
    public AllMealsDto getAllMeals() {
        AllMealsDto allMeals = new AllMealsDto();
        for (long i = 1; i <= mealRepository.count(); i++) {
            allMeals.addMeal(getMealById(i));
        }
        return allMeals;
    }

    @Override
    /* Create a meal plan with breakfast taking 30%, lunch 40% and dinner 30% */
    //TODO: Optimize the ratio if needed - e.g 32-38-30
    public Set<MealWithProductsAndTotalCaloriesDto> offerMealPlan(double requestedCalories) {
        Set<MealWithProductsAndTotalCaloriesDto> mealPlan = new LinkedHashSet<>();
        mealPlan.add(getMeal(0D, requestedCalories * 0.3, "breakfast"));
        mealPlan.add(getMeal(0D, requestedCalories * 0.4, "lunch"));
        mealPlan.add(getMeal(0D, requestedCalories * 0.3, "dinner"));
        return mealPlan;
    }

    /* provide a mea; pf certain type, filtered by meal type and calories. If no meal is found, increment calories difference by 0.5 */
    private MealWithProductsAndTotalCaloriesDto getMeal(double coefficient, double requestedCaloriesForMeal, String mealType) {
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
            return meals.get(randomIndex);
        } else {
            //TODO: If there is no meal of a certain meal type - breakfast, lunch, dinner, there will be a constant loop. FIXIT
            return getMeal(finalCoefficient, requestedCaloriesForMeal, mealType);
        }

    }


}
