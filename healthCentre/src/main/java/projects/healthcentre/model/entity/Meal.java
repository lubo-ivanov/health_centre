package projects.healthcentre.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import projects.healthcentre.model.enums.MealType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "meals")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meal_id")
    private Long id;

    @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(30)")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "meal_type", nullable = false)
    private MealType mealType;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "video_url")
    private String videoUrl;

    @OneToMany
    @JoinColumn(name = "picture_id")
    private Set<Picture> pictures;

    @OneToMany(mappedBy = "meal")
    private Set<MealProducts> mealProducts;
}