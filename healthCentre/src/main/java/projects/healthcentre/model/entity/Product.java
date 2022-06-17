package projects.healthcentre.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import projects.healthcentre.model.enums.ProductType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(15)", nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Integer calories;

    @Column(nullable = false)
    private String units;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_type", nullable = false)
    private ProductType productType;

    @OneToMany(mappedBy = "product")
    private Set<MealProducts> mealProducts = new HashSet<>();

    @OneToOne
    private Picture picture;
}

