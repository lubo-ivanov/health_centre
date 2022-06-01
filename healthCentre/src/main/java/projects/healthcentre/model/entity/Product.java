package projects.healthcentre.model.entity;

import projects.healthcentre.model.enums.ProductType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    private String name;
    private Integer calories;
    private String units;
    private ProductType productType;
    private Set<MealProducts> mealProducts = new HashSet<>();
    private Picture picture;

    public Product() {
    }

    @Column(columnDefinition = "VARCHAR(15)", nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    @Column(nullable = false)
    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "product_type", nullable = false)
    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @OneToMany(mappedBy = "product")
    public Set<MealProducts> getMealProducts() {
        return mealProducts;
    }

    public void setMealProducts(Set<MealProducts> mealProducts) {
        this.mealProducts = mealProducts;
    }

    @OneToOne
    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}

