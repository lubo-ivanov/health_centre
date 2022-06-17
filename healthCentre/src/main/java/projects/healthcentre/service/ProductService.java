package projects.healthcentre.service;

import projects.healthcentre.model.entity.Product;

import java.util.List;

public interface ProductService {
    Product findProductByName(String name);
    List<Product> findAllProductsByMealId(long id);
}
