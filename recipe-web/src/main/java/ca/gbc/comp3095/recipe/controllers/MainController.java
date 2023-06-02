/**********************************************************************************
 * Project: < comp3095_assignment1 >
 * Authors: < Israr Wahid, Roberto Borges >
 * Student Number: < 101348701, 101255891 >
 * Date: October 23rd 2022
 * Description: This java file is used to control our pages for non-registered users.
 **********************************************************************************/

package ca.gbc.comp3095.recipe.controllers;

import ca.gbc.comp3095.recipe.model.User;
import ca.gbc.comp3095.recipe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @RequestMapping({"/register", "register.html"})
    public String index(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "/register";
    }

    @PostMapping(value = "/save")
    public String save(User user, Model model) {
        if (userService.getUserByUsername(user.getUsername()) != null) {
            model.addAttribute("message", "Invalid User! " + user.getUsername() + " Username Already Taken!");
            return "/register";
        }
        userService.save(user);
        return "/login";
    }

    @RequestMapping(value = {"", "/", "/login", "/login.html"}, method = RequestMethod.GET)
    public String showLoginPage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "/login";
        }
        return "redirect:/registered/";
    }

    @RequestMapping({"/logout", "logout.html"})
    public String logout() {
        return "/logout";
    }

    @RequestMapping(value = {"/reset", "reset-password.html"}, method = RequestMethod.GET)
    public String reset(Model model) {
        return "/reset-password";
    }

    @RequestMapping(value = {"/reset", "reset-password.html"}, method = RequestMethod.POST)
    public String reset(HttpServletRequest request, Model model) {
        User users = userService.getUserByUsername(request.getParameter("username"));
        if (users == null) {
            model.addAttribute("message", "Invalid User! " + request.getParameter("username") + " cannot be found!");
            return "/reset-password";
        } else {
            if (!request.getParameter("password").equals(request.getParameter("confirmPassword"))) {
                model.addAttribute("badMatch", "Error! Passwords do not match!");
                return "/reset-password";
            }
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String EncodedPassword = passwordEncoder.encode(request.getParameter("password"));
            users.setPassword(EncodedPassword);
            userService.saveNewPassword(users);
            model.addAttribute("message", "You have successfully changed your password!");
        }
        return "/reset-success";
    }

}

