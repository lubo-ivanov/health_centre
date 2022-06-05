package projects.healthcentre.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projects.healthcentre.model.dto.AllMealsDto;
import projects.healthcentre.model.dto.MealWithProductsAndTotalCaloriesDto;
import projects.healthcentre.service.MealService;

@RequestMapping("/")
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
    private ResponseEntity<AllMealsDto> getAllMeals () {
        return new ResponseEntity<>(mealService.getAllMeals(), HttpStatus.OK);
    }

}
