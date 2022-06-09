package projects.healthcentre.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import projects.healthcentre.model.enums.MealType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "meals")
public class Meal extends BaseEntity {
    private String name;
    private MealType mealType;
    private String description;
    private String videoUrl;
    private Set<Picture> picture;

    public Meal() {
    }

    private Set<MealProducts> mealProducts = new HashSet<>();

    @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(30)")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "meal_type", nullable = false)
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

    @Column(name = "video_url")
    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @OneToMany
    public Set<Picture> getPicture() {
        return picture;
    }

    public void setPicture(Set<Picture> picture) {
        this.picture = picture;
    }
}
