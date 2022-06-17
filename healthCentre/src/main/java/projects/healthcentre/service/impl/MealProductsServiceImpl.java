package projects.healthcentre.service.impl;

import org.springframework.stereotype.Service;
import projects.healthcentre.model.entity.MealProducts;
import projects.healthcentre.repository.MealProductRepository;
import projects.healthcentre.service.MealProductsService;

@Service
public class MealProductsServiceImpl implements MealProductsService {
    private final MealProductRepository mealProductRepository;

    public MealProductsServiceImpl(MealProductRepository mealProductRepository) {
        this.mealProductRepository = mealProductRepository;
    }

    @Override
    public MealProducts save(MealProducts mealProduct) {
        return mealProductRepository.save(mealProduct);
    }
}
