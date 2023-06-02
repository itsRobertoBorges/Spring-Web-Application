/**********************************************************************************
 * Project: < comp3095_assignment1 >
 * Authors: < Israr Wahid, Roberto Borges >
 * Student Number: < 101348701, 101255891 >
 * Date: December 3rd 2022
 * Description: This file is used to set up our 'favorites' services
 **********************************************************************************/
package ca.gbc.comp3095.recipe.services;

import ca.gbc.comp3095.recipe.model.Event;
import ca.gbc.comp3095.recipe.repositories.EventRepository;
import ca.gbc.comp3095.recipe.repositories.FavoriteRepository;
import ca.gbc.comp3095.recipe.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private UserRepository userRepository;

    public Event getFavoriteById(Long id){
        return favoriteRepository.getFavoriteById(id);
    }

    public void deleteById(Long id){
        favoriteRepository.deleteById(id);
    }

    public Iterable<Event> findAll(){
        return favoriteRepository.findAll();
    }

    public void save(Event event){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        event.setUser(userRepository.getUserByUsername(authentication.getName()));
        favoriteRepository.save(event);
    }
}


