package org.tburke.javavideogamebackendexample.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tburke.javavideogamebackendexample.models.Motd;
import org.tburke.javavideogamebackendexample.repo.MotdRepository;

import java.util.Date;

@Service
public class MotdService {
    @Autowired
    private MotdRepository motdRepository;

    public Motd getMessageOfTheDay(Date date) {
        return motdRepository.findByMessageDate(date);
    }
}