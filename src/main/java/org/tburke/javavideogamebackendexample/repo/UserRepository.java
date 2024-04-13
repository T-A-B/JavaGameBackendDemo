package org.tburke.javavideogamebackendexample.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tburke.javavideogamebackendexample.models.MatchHistory;
import org.tburke.javavideogamebackendexample.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String userName);

}
