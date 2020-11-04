package com.blacklightsw.assignment.models.dto;

import java.util.List;

/**
 * DTO class for Game
 *
 * @author Adarsh Srivastava
 */

public class GameDto {
    private long gameId;
    private List<Long> idOfUsersWhoPlayedThisMatch;
    private String matchStartTime;

    public GameDto(long gameId, List<Long> idOfUsersWhoPlayedThisMatch, String matchStartTime) {
        this.gameId = gameId;
        this.idOfUsersWhoPlayedThisMatch = idOfUsersWhoPlayedThisMatch;
        this.matchStartTime = matchStartTime;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public List<Long> getIdOfUsersWhoPlayedThisMatch() {
        return idOfUsersWhoPlayedThisMatch;
    }

    public void setIdOfUsersWhoPlayedThisMatch(List<Long> idOfUsersWhoPlayedThisMatch) {
        this.idOfUsersWhoPlayedThisMatch = idOfUsersWhoPlayedThisMatch;
    }

    public String getMatchStartTime() {
        return matchStartTime;
    }

    public void setMatchStartTime(String matchStartTime) {
        this.matchStartTime = matchStartTime;
    }
}
