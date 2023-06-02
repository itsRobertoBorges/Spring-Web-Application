/**********************************************************************************
 * Project: < comp3095_assignment1 >
 * Authors: < Israr Wahid, Roberto Borges >
 * Student Number: < 101348701, 101255891 >
 * Date: October 23rd 2022
 * Description: This java file is used to set the user entity inside our database.
 **********************************************************************************/


package ca.gbc.comp3095.recipe.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    @Column(unique = true)
    private String username;
    private String password;
    private boolean enabled;

    @ManyToMany(mappedBy = "likedByUsers")
    private Set<Recipe> likedRecipes = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "author")
    private Set<Recipe> recipes;

    @OneToMany(mappedBy = "recipe")
    private Set<Meal> meals;

    @Lob
    private Byte[] image;

    public User() {
    }

    public User(Long id, String firstName, String lastName, String emailAddress, String username, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.username = username;
        this.password = password;
    }

    public User(Long id, String firstName, String lastName, String emailAddress, String username, String password, boolean enabled, Set<Recipe> likedRecipes, Set<Role> roles, Set<Recipe> recipes, Set<Meal> meals) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.likedRecipes = likedRecipes;
        this.roles = roles;
        this.recipes = recipes;
        this.meals = meals;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String address) {
        this.emailAddress = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Recipe> getLikedRecipes() {
        return likedRecipes;
    }

    public void setLikedRecipes(Set<Recipe> likedRecipes) {
        this.likedRecipes = likedRecipes;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    public Set<Meal> getMeals() {
        return meals;
    }

    public void setMeals(Set<Meal> meals) {
        this.meals = meals;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + emailAddress + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", likedRecipes=" + likedRecipes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

