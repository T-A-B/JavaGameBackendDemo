package org.tburke.javavideogamebackendexample.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tburke.javavideogamebackendexample.models.Motd;
import org.tburke.javavideogamebackendexample.service.MotdService;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class MotdController {
    @Autowired
    private MotdService motdService;

    @GetMapping("/motd")
    public ResponseEntity<Motd> getMessageOfTheDay() {
        Motd motd = motdService.getMessageOfTheDay(new Date()); // Assuming you want today's message
        if (motd != null) {
            return ResponseEntity.ok(motd);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}