/**********************************************************************************
 * Project: < comp3095_assignment1 >
 * Authors: < Israr Wahid, Roberto Borges >
 * Student Number: < 101348701, 101255891 >
 * Date: October 23rd 2022
 * Description: This file basically implements the interface required for spring
 * security authentication. The more security the better regardless of the task.
 **********************************************************************************/




package ca.gbc.comp3095.recipe.services;


import ca.gbc.comp3095.recipe.configuration.MyUserDetails;
import ca.gbc.comp3095.recipe.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import ca.gbc.comp3095.recipe.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserDetails(user);
    }

}
