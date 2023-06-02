package ca.gbc.comp3095.recipe.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
/**********************************************************************************
 * Project: < comp3095_assignment1 >
 * Authors: < Israr Wahid, Roberto Borges >
 * Student Number: < 101348701, 101255891 >
 * Date: October 23rd 2022
 * Description: This file sets up recipes in our application
 **********************************************************************************/



import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int prepTime;
    private int cookTime;
    private int totalTime;
    @Lob
    private String ingredients;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateAdded;

    @ManyToMany
    @JoinTable(name = "recipe_like",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> likedByUsers = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "users_recipes", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "recipe_id"))
    private User author;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructions_id", referencedColumnName = "id")
    private Instructions steps;

    @Lob
    private Byte[] image;

    public Recipe() {
    }

    public Recipe(Long id, String name, int prepTime, int cookTime, int totalTime, String ingredients, Instructions steps, LocalDate dateAdded) {
        this.id = id;
        this.name = name;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.totalTime = totalTime;
        this.steps = steps;
        this.dateAdded = dateAdded;
    }

    public Recipe(Long id, String name, int prepTime, int cookTime, int totalTime, String ingredients, Instructions steps, LocalDate dateAdded, Set<User> likedByUsers, User author) {
        this.id = id;
        this.name = name;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.totalTime = totalTime;
        this.ingredients = ingredients;
        this.steps = steps;
        this.dateAdded = dateAdded;
        this.likedByUsers = likedByUsers;
        this.author = author;
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

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public int getCookTime() {
        return cookTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Set<User> getLikedByUsers() {
        return likedByUsers;
    }

    public void setLikedByUsers(Set<User> likedByUsers) {
        this.likedByUsers = likedByUsers;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Instructions getSteps() {
        return steps;
    }

    public void setSteps(Instructions steps) {
        this.steps = steps;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prepTime='" + prepTime + '\'' +
                ", cookTime='" + cookTime + '\'' +
                ", totalTime='" + totalTime + '\'' +
                ", ingredients=" + ingredients +
                ", instructions='" + steps + '\'' +
                ", author=" + author +
                ", likedByUsers=" + likedByUsers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(id, recipe.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

