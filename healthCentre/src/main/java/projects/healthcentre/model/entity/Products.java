package projects.healthcentre.model.entity;

import org.hibernate.persister.walking.spi.CollectionDefinition;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Products extends BaseEntity {
    private String name;
    private Integer calories;
    private String units;

    public Products() {
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
}

