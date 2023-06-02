/**********************************************************************************
 * Project: < comp3095_assignment1 >
 * Authors: < Israr Wahid, Roberto Borges >
 * Student Number: < 101348701, 101255891 >
 * Date: October 23rd 2022
 * Description: This file is used to set up meal services
 **********************************************************************************/




package ca.gbc.comp3095.recipe.services;


import ca.gbc.comp3095.recipe.model.Meal;
import ca.gbc.comp3095.recipe.repositories.MealRepository;
import ca.gbc.comp3095.recipe.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MealService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MealRepository mealRepository;

    public void save(Meal meal){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        meal.setUser(userRepository.getUserByUsername(authentication.getName()));
        mealRepository.save(meal);
    }

    public List<Meal> findAll(){
        return mealRepository.findAll();
    }
}
