package com.blacklightsw.assignment.models.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
/**
 * Entity class for Game
 *
 * @author Adarsh Srivastava
 */
@Entity
public class Game {
    @Id
    private Long gameId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @ManyToMany(mappedBy = "gamesPlayed", cascade = CascadeType.ALL)
    private Collection<User> gamePlayedByUsers = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "winner_user_id")
    private User gameWonByUser;

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Collection<User> getGamePlayedByUsers() {
        return gamePlayedByUsers;
    }

    public void setGamePlayedByUsers(Collection<User> gamePlayedByUsers) {
        this.gamePlayedByUsers = gamePlayedByUsers;
    }

    public User getGameWonByUser() {
        return gameWonByUser;
    }

    public void setGameWonByUser(User gameWonByUser) {
        this.gameWonByUser = gameWonByUser;
    }
}
