package projects.healthcentre.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projects.healthcentre.model.dto.AllMealsDto;
import projects.healthcentre.model.dto.CaloriesInputProfileDto;
import projects.healthcentre.model.dto.MealSeedDto;
import projects.healthcentre.model.dto.MealWithProductsAndTotalCaloriesDto;
import projects.healthcentre.model.entity.Meal;
import projects.healthcentre.service.MealService;

import java.util.Set;

@RequestMapping("/api/v1/meals")
@RestController
public class MealsController {
    private final MealService mealService;

    @Autowired
    public MealsController(MealService mealService) {
        this.mealService = mealService;
    }


    @GetMapping({"/{mealId}"})
    private ResponseEntity<MealWithProductsAndTotalCaloriesDto> getMeal(@PathVariable("mealId") Long mealId) {
        return new ResponseEntity<>(mealService.getMealById(mealId), HttpStatus.OK);
    }

    @GetMapping("/all")
    private ResponseEntity<AllMealsDto> getAllMeals() {
        return new ResponseEntity<>(mealService.getAllMeals(), HttpStatus.OK);
    }

    @GetMapping({"/plan"})
    private ResponseEntity<Set<MealWithProductsAndTotalCaloriesDto>> getMealPlan(CaloriesInputProfileDto caloriesInputProfileDto) {
        return new ResponseEntity<>(mealService.offerMealPlan(caloriesInputProfileDto), HttpStatus.OK);
    }


    @PostMapping
    private ResponseEntity<String> createMeal(MealSeedDto mealSeedDto) {
        Meal savedMeal = mealService.saveMeal(mealSeedDto);
        String location = "/api/v1/meals" + savedMeal.getId().toString();
        return new ResponseEntity<>(location, HttpStatus.CREATED);
    }
}
