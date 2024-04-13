package org.tburke.javavideogamebackendexample.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tburke.javavideogamebackendexample.models.Motd;

import java.util.Date;

@Repository
public interface MotdRepository extends JpaRepository<Motd, Long> {
    Motd findByMessageDate(Date date);

}