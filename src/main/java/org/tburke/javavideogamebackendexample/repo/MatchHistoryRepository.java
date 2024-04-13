package org.tburke.javavideogamebackendexample.repo;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.tburke.javavideogamebackendexample.models.MatchHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchHistoryRepository extends JpaRepository<MatchHistory, Long> {
    @Query("SELECT mh FROM MatchHistory mh WHERE mh.user1.name = :userName OR mh.user2.name = :userName")
    List<MatchHistory> findByUserName(@Param("userName") String userName);
}