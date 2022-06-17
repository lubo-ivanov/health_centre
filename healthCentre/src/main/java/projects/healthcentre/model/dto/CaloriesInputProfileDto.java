package projects.healthcentre.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import projects.healthcentre.model.enums.ActivityLevel;
import projects.healthcentre.model.enums.Gender;
import projects.healthcentre.model.enums.WeightControl;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CaloriesInputProfileDto {

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private int age;
    private Double weight;
    private Double height;
    @Enumerated(EnumType.STRING)
    private WeightControl weightControl;
    @Enumerated(EnumType.STRING)
    private ActivityLevel activityLevel;
}
