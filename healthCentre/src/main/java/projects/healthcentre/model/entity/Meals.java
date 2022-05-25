package projects.healthcentre.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "meals")
public class Meals extends BaseEntity{
    private String name;
    private MealTypes mealType;
    private String description;

    public Meals() {
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
    public MealTypes getMealType() {
        return mealType;
    }

    public void setMealType(MealTypes mealType) {
        this.mealType = mealType;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
