package projects.healthcentre.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.healthcentre.repository.MealRepository;
import projects.healthcentre.service.MealService;

@Service
public class MealServiceImpl implements MealService {
    private final MealRepository mealRepository;

    @Autowired
    public MealServiceImpl(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }
}
