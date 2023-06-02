package ca.gbc.comp3095.recipe.repositories;



import ca.gbc.comp3095.recipe.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface FavoriteRepository extends CrudRepository<Event, Long> {
    Event getFavoriteById(Long id);
}
