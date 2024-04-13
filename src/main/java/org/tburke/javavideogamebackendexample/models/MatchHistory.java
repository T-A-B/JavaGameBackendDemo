package org.tburke.javavideogamebackendexample.models;

import jakarta.persistence.*;

@Entity
@Table(name = "\"MatchHistory\"")
public class MatchHistory {
    @Id
    private Long matchId;

    @ManyToOne
    @JoinColumn(name = "user_Id1", referencedColumnName = "userId")
    private User user1;

    @ManyToOne
    @JoinColumn(name = "user_Id2", referencedColumnName = "userId")
    private User user2;

    @ManyToOne
    @JoinColumn(name = "winner_User_Id", referencedColumnName = "userId")
    private User winner;
    private String MatchResult;
    private String MatchDate;

public Long getMatchId() {
        return matchId;
    }

    public String getMatchResult() {
        return MatchResult;
    }

    public void setMatchResult(String result) {
        this.MatchResult = result;
    }

    public String getMatchDate() {
        return MatchDate;
    }

    public void setMatchDate(String date) {
        this.MatchDate = date;
    }



    public User getUser1() {
        return user1;
    }

    public void setUser1(User user) {
        this.user1 = user;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user) {
        this.user2 = user;
    }

    public User getWinner() {
        return winner;
    }

    public void setWinner(User winner) {
        this.winner = winner;
    }



}
