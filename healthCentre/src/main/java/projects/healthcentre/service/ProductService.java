package projects.healthcentre.service;

import projects.healthcentre.model.entity.Product;

public interface ProductService {
    public Product findProductByName(String name);
}
