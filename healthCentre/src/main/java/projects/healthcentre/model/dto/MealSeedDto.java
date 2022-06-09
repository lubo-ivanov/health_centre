package projects.healthcentre.model.dto;

import projects.healthcentre.model.entity.Picture;
import projects.healthcentre.model.enums.MealType;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MealSeedDto {
    private String name;
    private MealType mealType;
    private String description;
    private String videoUrl;
    private Set<Picture> picture;
    private Map<String, Integer> productWithQuantity;

    public MealSeedDto() {
        this.productWithQuantity = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Set<Picture> getPicture() {
        return picture;
    }

    public void setPicture(Set<Picture> picture) {
        this.picture = picture;
    }

    public Map<String, Integer> getProductWithQuantity() {
        return productWithQuantity;
    }

    public void setProductWithQuantity(Map<String, Integer> productWithQuantity) {
        this.productWithQuantity = productWithQuantity;
    }
}
