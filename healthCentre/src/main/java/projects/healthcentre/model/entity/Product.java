package projects.healthcentre.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    private String name;
    private Integer calories;
    private String units;

    public Product() {
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    @Column
    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
}

