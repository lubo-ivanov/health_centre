package projects.healthcentre.model.entity;

import org.hibernate.persister.walking.spi.CollectionDefinition;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    private String name;
    private Integer calories;
    private String units;
    private Set<MealProducts> mealProducts = new HashSet<>();

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

    @OneToMany(mappedBy = "product")
    public Set<MealProducts> getMealProducts() {
        return mealProducts;
    }

    public void setMealProducts(Set<MealProducts> mealProducts) {
        this.mealProducts = mealProducts;
    }
}

