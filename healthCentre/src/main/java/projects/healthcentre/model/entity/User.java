package projects.healthcentre.model.entity;

import projects.healthcentre.model.enums.UserType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private UserType userType;
    private Set<Meal> mealPlan;

    public User() {
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "user_name", nullable = false, unique = true)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type", nullable = false)
    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @ManyToMany
    public Set<Meal> getMealPlan() {
        return mealPlan;
    }

    public void setMealPlan(Set<Meal> mealPlan) {
        this.mealPlan = mealPlan;
    }
}
