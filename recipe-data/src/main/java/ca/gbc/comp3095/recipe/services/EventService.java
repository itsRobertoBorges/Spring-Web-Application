/**********************************************************************************
 * Project: < comp3095_assignment1 >
 * Authors: < Israr Wahid, Roberto Borges >
 * Student Number: < 101348701, 101255891 >
 * Date: October 23rd 2022
 * Description: This file is used to set up event services
 **********************************************************************************/





package ca.gbc.comp3095.recipe.services;

import ca.gbc.comp3095.recipe.model.Event;
import ca.gbc.comp3095.recipe.repositories.EventRepository;
import ca.gbc.comp3095.recipe.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    public Event getEventById(Long id){
        return eventRepository.getEventById(id);
    }

    public void deleteById(Long id){
        eventRepository.deleteById(id);
    }

    public Iterable<Event> findAll(){
        return eventRepository.findAll();
    }

    public void save(Event event){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        event.setUser(userRepository.getUserByUsername(authentication.getName()));
        eventRepository.save(event);
    }
}

