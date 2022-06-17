package projects.healthcentre.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.healthcentre.model.entity.Product;
import projects.healthcentre.repository.ProductRepository;
import projects.healthcentre.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findProductByName(String name) {
        return productRepository.findProductByName(name);
    }

    @Override
    public List<Product> findAllProductsByMealId(long id) {
        return productRepository.findAllProductsByMealId(id);
    }
}
