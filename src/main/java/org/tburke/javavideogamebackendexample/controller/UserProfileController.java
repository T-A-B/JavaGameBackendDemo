package org.tburke.javavideogamebackendexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.tburke.javavideogamebackendexample.models.User;
import org.tburke.javavideogamebackendexample.repo.UserRepository;

@Controller
public class UserProfileController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{userId}")
    public String userProfile(@PathVariable Long userId, Model model) {
        User user = userRepository.findById(userId).orElse(null);
        model.addAttribute("user", user);
        System.out.println("User: " + user.getName());
        System.out.println(user.getImageId());
        return "userProfile";
    }

    @GetMapping("/users/{userId}/edit")
    public String showEditForm(@PathVariable Long userId, Model model) {
        User user = userRepository.findById(userId).orElse(null);
        model.addAttribute("user", user);
        return "editProfile";
    }

    @PostMapping("/users/{userId}/edit")
    public String updateUser(@PathVariable Long userId, User userForm, Model model) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            user.setName(userForm.getName());
            user.setPassword(userForm.getPassword());
            user.setImageId(userForm.getImageId());
            user.setBiography(userForm.getBiography());
            user.setBirthday(userForm.getBirthday());
            userRepository.save(user);
        }
        return "redirect:/user/" + userId;
    }
}
