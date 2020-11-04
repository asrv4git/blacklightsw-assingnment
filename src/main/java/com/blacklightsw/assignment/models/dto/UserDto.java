package com.blacklightsw.assignment.models.dto;

/**
 * DTO class for User
 *
 * @author Adarsh Srivastava
 */

public class UserDto {
    private Long userId;
    private String name;
    private int numberOfGamesPLayed;
    private int gamesWon;
    private long lastGameId;

    public UserDto(Long userId, String name, int numberOfGamesPLayed, int gamesWon, long lastGameId) {
        this.userId = userId;
        this.name = name;
        this.numberOfGamesPLayed = numberOfGamesPLayed;
        this.gamesWon = gamesWon;
        this.lastGameId = lastGameId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfGamesPLayed() {
        return numberOfGamesPLayed;
    }

    public void setNumberOfGamesPLayed(int numberOfGamesPLayed) {
        this.numberOfGamesPLayed = numberOfGamesPLayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public long getLastGameId() {
        return lastGameId;
    }

    public void setLastGameId(long lastGameId) {
        this.lastGameId = lastGameId;
    }
}
