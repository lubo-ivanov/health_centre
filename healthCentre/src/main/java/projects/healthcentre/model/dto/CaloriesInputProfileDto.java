package projects.healthcentre.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private Double height;
    private Double length;
    @Enumerated(EnumType.STRING)
    private WeightControl weightControl;
}
