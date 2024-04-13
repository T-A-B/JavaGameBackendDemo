package org.tburke.javavideogamebackendexample.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.tburke.javavideogamebackendexample.models.MatchHistory;
import org.tburke.javavideogamebackendexample.repo.UserRepository;
import org.tburke.javavideogamebackendexample.service.MatchHistoryService;
import org.tburke.javavideogamebackendexample.service.UserService;

import java.util.List;

@Controller
public class MatchHistoryController {

    private final MatchHistoryService service;


    public MatchHistoryController(MatchHistoryService service) {
        this.service = service;
    }

    @GetMapping("/matches")
    public String showMatchHistory(@RequestParam(name = "userName", required = false) String userName, Model model) {
        List<MatchHistory> matchHistories;
        if (userName != null && !userName.isEmpty()) {
            matchHistories = service.findAllByUserName(userName);
        } else {
            matchHistories = service.findAll();
        }
        model.addAttribute("matches", matchHistories);
        return "matches";
    }

    @GetMapping("/high-scores")
    public String showHighScores(Model model) {
        model.addAttribute("highScores", service.calculateHighScores());
        return "highScores";  // Ensure you have a corresponding Thymeleaf template
    }
}