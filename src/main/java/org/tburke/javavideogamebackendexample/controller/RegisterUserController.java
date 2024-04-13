package org.tburke.javavideogamebackendexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.tburke.javavideogamebackendexample.models.User;
import org.tburke.javavideogamebackendexample.service.UserService;


@Controller
public class RegisterUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(User user, BindingResult result) {

            userService.registerUser(user);

            return "register";

    }
}