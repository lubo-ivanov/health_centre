package projects.healthcentre.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.healthcentre.model.dto.AllMealsDto;
import projects.healthcentre.model.dto.CaloriesInputProfileDto;
import projects.healthcentre.model.dto.MealSeedDto;
import projects.healthcentre.model.dto.MealWithProductsAndTotalCaloriesDto;
import projects.healthcentre.model.entity.Meal;
import projects.healthcentre.model.entity.MealProducts;
import projects.healthcentre.model.entity.Product;
import projects.healthcentre.repository.MealRepository;
import projects.healthcentre.service.MealProductsService;
import projects.healthcentre.service.MealService;
import projects.healthcentre.service.ProductService;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class MealServiceImpl implements MealService {
    private final MealRepository mealRepository;
    private final ModelMapper modelMapper;
    private final ProductService productService;

    private final MealProductsService mealProductsService;

    @Autowired
    public MealServiceImpl(MealRepository mealRepository, ModelMapper modelMapper, ProductService productService, MealProductsService mealProductsService) {
        this.mealRepository = mealRepository;
        this.mealProductsService = mealProductsService;
        this.modelMapper = modelMapper;
        this.productService = productService;
    }


    @Override
    /* Get a meal and all of its products by Meal ID */
    public MealWithProductsAndTotalCaloriesDto getMealById(Long id) {
        MealWithProductsAndTotalCaloriesDto mealWithProducts = new MealWithProductsAndTotalCaloriesDto();
        Meal meal = mealRepository.getMealById(id);
        mealWithProducts.setName(meal.getName());
        mealWithProducts.setMealType(meal.getMealType());
        List<Product> products = productService.findAllProductsByMealId(id);
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
    //Note: Optimize the ratio if needed - e.g 32-38-30
    public Set<MealWithProductsAndTotalCaloriesDto> offerMealPlan(CaloriesInputProfileDto caloriesInputProfileDto) {
        Set<MealWithProductsAndTotalCaloriesDto> mealPlan = new LinkedHashSet<>();
        double requestedCalories = calculateCalories(caloriesInputProfileDto);
        mealPlan.add(getMeal(0D, requestedCalories * 0.3, "breakfast"));
        mealPlan.add(getMeal(0D, requestedCalories * 0.4, "lunch"));
        mealPlan.add(getMeal(0D, requestedCalories * 0.3, "dinner"));
        return mealPlan;
    }

    public double calculateCalories(CaloriesInputProfileDto caloriesInputProfileDto) {
        double calories = 0D;
        calories = caloriesInputProfileDto.getGender().toString().equalsIgnoreCase("male")
                ? (88.4 + 13.4 * caloriesInputProfileDto.getWeight())
                + (4.8 * caloriesInputProfileDto.getHeight()) - (5.68 * caloriesInputProfileDto.getAge())
                : (447.6 + 9.25 * caloriesInputProfileDto.getWeight())
                + (3.10 * caloriesInputProfileDto.getHeight()) - (4.33 * caloriesInputProfileDto.getAge());
        switch (caloriesInputProfileDto.getActivityLevel().toString()) {
            case "SEDENTARY" -> calories *= 1.1;
            case "LIGHTLY_ACTIVE" -> calories *= 1.2;
            case "MODERATELY_ACTIVE" -> calories *= 1.35;
            case "VERY_ACTIVE" -> calories *= 1.4;
            case "EXTREMELY_ACTIVE" -> calories *= 1.6;
        }

        switch (caloriesInputProfileDto.getWeightControl().toString()) {
            case "LOSS" -> {
                return calories * 0.8;
            }
            case "GAIN" -> {
                return calories * 1.2;
            }
            default -> {
                return calories;
            }
        }
    }

    @Override
    public Meal saveMeal(MealSeedDto mealSeedDto) {
        Meal mealToSave = modelMapper.map(mealSeedDto, Meal.class);
        Meal savedMeal = mealRepository.save(mealToSave);
        Set<MealProducts> mealProducts = new HashSet<>();

        mealSeedDto.getProductWithQuantity().forEach((productName, productQuantity) -> {
            Product product = productService.findProductByName(productName);
            MealProducts mealProduct = MealProducts.builder().product(product)
                    .productQuantity(productQuantity).meal(savedMeal).build();
            MealProducts savedMealProduct = mealProductsService.save(mealProduct);
            mealProducts.add(savedMealProduct);
        });
        savedMeal.setMealProducts(mealProducts);
        mealRepository.save(savedMeal);
        mealRepository.save(mealToSave);
        return mealToSave;
    }

    /* provide a meal of certain type, filtered by meal type and calories. If no meal is found, increment calories difference by 0.5 */
    public MealWithProductsAndTotalCaloriesDto getMeal(double coefficient,
                                                       double requestedCaloriesForMeal, String mealType) {
        double finalCoefficient = coefficient + 0.5;
        List<MealWithProductsAndTotalCaloriesDto> meals = getAllMeals()
                .getAllMeals()
                .stream()
                .filter(m -> m.getMealType().toString().equalsIgnoreCase(mealType))
                .filter(m -> m.getTotalCalories() <= requestedCaloriesForMeal * (1 + finalCoefficient)
                        && m.getTotalCalories() >= requestedCaloriesForMeal * (1 - finalCoefficient))
                .toList();
//TODO: make query in repo - where mealType, calories in (lower coef, upper coef)
        if (!meals.isEmpty()) {
            int randomIndex = ThreadLocalRandom.current().nextInt(0, meals.size());
            return meals.get(randomIndex);
        } else {
            //TODO: If there is no meal of a certain meal type - breakfast, lunch, dinner, there will be a constant loop. FIXIT
            return getMeal(finalCoefficient, requestedCaloriesForMeal, mealType);
        }
    }


}
