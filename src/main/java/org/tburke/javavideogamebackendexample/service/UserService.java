package org.tburke.javavideogamebackendexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tburke.javavideogamebackendexample.models.Motd;
import org.tburke.javavideogamebackendexample.models.User;
import org.tburke.javavideogamebackendexample.repo.MotdRepository;
import org.tburke.javavideogamebackendexample.repo.UserRepository;

import java.util.Date;
@Service

public class UserService {


        @Autowired
        private UserRepository userRepository;

        public User getUser(long id) {
            return userRepository.findById(id).get();
        }




    public User registerUser(User user) {
        return userRepository.save(user);
    }
}

