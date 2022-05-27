package projects.healthcentre.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class MealProducts extends BaseEntity {
    private Meal meal;
    private Product product;
    private Integer productQuantity;

    public MealProducts() {
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "meal_id")
    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Column(name = "product_quantity", nullable = false)
    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MealProducts that = (MealProducts) o;
        return meal.equals(that.meal) && product.equals(that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(meal, product);
    }
}
