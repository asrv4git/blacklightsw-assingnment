package com.blacklightsw.assignment.models.entity;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * Entity class for User
 *
 * @author Adarsh Srivastava
 */

@Entity
public class User {
    @Id
    Long userId;

    @NonNull
    String userName;

    @ManyToMany(cascade = CascadeType.ALL)
    Collection<Game> gamesPlayed = new LinkedHashSet<>();

    @OneToMany(mappedBy = "gameWonByUser", cascade = CascadeType.ALL)
    private Collection<Game> gamesWon = new LinkedHashSet<>();

    Long lastGameId;

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Collection<Game> getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(Collection<Game> gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Collection<Game> getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(Collection<Game> gamesWon) {
        this.gamesWon = gamesWon;
    }

    public Long getLastGameId() {
        return lastGameId;
    }

    public void setLastGameId(Long lastGameId) {
        this.lastGameId = lastGameId;
    }
}
