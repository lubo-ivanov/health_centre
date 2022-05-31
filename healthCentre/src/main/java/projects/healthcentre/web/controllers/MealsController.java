package projects.healthcentre.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import projects.healthcentre.service.MealService;

@Controller
public class MealsController {
    private final MealService mealService;

    @Autowired
    public MealsController(MealService mealService) {
        this.mealService = mealService;
    }

}
