package projects.healthcentre.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import projects.healthcentre.model.entity.Picture;
import projects.healthcentre.model.enums.MealType;

import java.util.Map;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MealSeedDto {
    private String name;
    private MealType mealType;
    private String description;
    private String videoUrl;
    private Set<Picture> picture;
    private Map<String, Integer> productWithQuantity;

}

