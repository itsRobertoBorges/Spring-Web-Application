/**********************************************************************************
 * Project: < comp3095_assignment1 >
 * Authors: < Israr Wahid, Roberto Borges >
 * Student Number: < 101348701, 101255891 >
 * Date: October 23rd 2022
 * Description: This file sets up favorites in our application
 * **********************************************************************************/


package ca.gbc.comp3095.recipe.repositories;


import ca.gbc.comp3095.recipe.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
    Event getEventById(Long id);
}
