package org.tburke.javavideogamebackendexample.repo;

public class PlayerScore {

    private final long userId;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    private String userName;
    private final long totalWins;
    private final long totalMatches;
    private final double winRatio;

    public PlayerScore(long userId, long totalWins, long totalMatches, double winRatio) {
        this.userId = userId;
        this.totalWins = totalWins;
        this.totalMatches = totalMatches;
        this.winRatio = winRatio;
    }

    // Getters
    public long getUserId() {
        return userId;
    }

    public long getTotalWins() {
        return totalWins;
    }

    public long getTotalMatches() {
        return totalMatches;
    }

    public double getWinRatio() {
        return winRatio;
    }

}

