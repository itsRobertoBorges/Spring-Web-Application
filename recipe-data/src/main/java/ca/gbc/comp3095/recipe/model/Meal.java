/**********************************************************************************
 * Project: < comp3095_assignment1 >
 * Authors: < Israr Wahid, Roberto Borges >
 * Student Number: < 101348701, 101255891 >
 * Date: October 23rd 2022
 * Description: This file sets up meals in our application
 **********************************************************************************/




package ca.gbc.comp3095.recipe.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "users_meals", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "meal_id"))
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "meal_recipe", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "meal_id"))
    private Recipe recipe;

    public Meal() {
    }

    public Meal(Long id, String name, LocalDate date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public Meal(Long id, String name, LocalDate date, User user, Recipe recipe) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.user = user;
        this.recipe = recipe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateAdded=" + date +
                ", user=" + user +
                ", recipe=" + recipe +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return Objects.equals(id, meal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
