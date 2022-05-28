package projects.healthcentre.model.entity;

import projects.healthcentre.model.enums.MealType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "meals")
public class Meal extends BaseEntity{
    private String name;
    private MealType mealType;
    private String description;


    private Set<MealProducts> mealProducts = new HashSet<>();

    public Meal() {
    }

    @Column (nullable = false, unique = true, columnDefinition = "VARCHAR(30)")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(mappedBy = "meal")
    public Set<MealProducts> getMealProducts() {
        return mealProducts;
    }

    public void setMealProducts(Set<MealProducts> mealProducts) {
        this.mealProducts = mealProducts;
    }
}
