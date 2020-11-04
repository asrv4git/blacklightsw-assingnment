package com.blacklightsw.assignment.component;

import com.blacklightsw.assignment.models.entity.Game;
import com.blacklightsw.assignment.models.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;
import java.sql.Date;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 * This class is responsible for propagating some dummy data in data base
 *
 * @author Adarsh Srivastava
 */

@Component
public class DumpDummyDataRunner implements CommandLineRunner {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public void run(String... args) throws Exception {
        //user 1
        User user1 = new User();
        user1.setUserId(1001L);
        user1.setUserName("John Oliver");

        //user 2
        User user2 = new User();
        user2.setUserId(1002L);
        user2.setUserName("Peter Parker");

        //user 3
        User user3 = new User();
        user3.setUserId(1003L);
        user3.setUserName("Olivia Wells");

        //user 4
        User user4 = new User();
        user4.setUserId(1004L);
        user4.setUserName("Emma Watson");

        //game 1
        Game game1 = new Game();
        game1.setGameId(50001L);
        game1.setStartTime(Date.from(Instant.now().plus(Duration.ofDays(2))));
        game1.setGamePlayedByUsers(Arrays.asList(user1, user4));
        game1.setGameWonByUser(null); //null signifies no user has won the game (game is not played yet)

        //game 2
        Game game2 = new Game();
        game2.setGameId(50002L);
        game2.setStartTime(Date.from(Instant.now().minus(Duration.ofDays(1))));
        game2.setGamePlayedByUsers(Arrays.asList(user3, user2));
        game2.setGameWonByUser(user2);

        //game 3
        Game game3 = new Game();
        game3.setGameId(50003L);
        game3.setStartTime(Date.from(Instant.now().plus(Duration.ofHours(10))));
        game3.setGamePlayedByUsers(Arrays.asList(user1, user3));
        game3.setGameWonByUser(null);

        //game 4
        Game game4 = new Game();
        game4.setGameId(50004L);
        game4.setStartTime(Date.from(Instant.now().minus(Duration.ofHours(2))));
        game4.setGamePlayedByUsers(Arrays.asList(user4, user2));
        game4.setGameWonByUser(user4);

        user1.setGamesPlayed(Arrays.asList(game3, game1));
        user2.setGamesPlayed(Arrays.asList(game2, game4));
        user3.setGamesPlayed(Arrays.asList(game2, game3));
        user4.setGamesPlayed(Arrays.asList(game1, game4));

        user4.getGamesWon().addAll(Arrays.asList(game2));
        user4.getGamesWon().addAll(Arrays.asList(game4));

        user1.setLastGameId(game3.getGameId());
        user2.setLastGameId(game4.getGameId());
        user3.setLastGameId(game3.getGameId());
        user4.setLastGameId(game4.getGameId());

        SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(user1);
        session.persist(user2);
        session.persist(user3);
        session.persist(user4);

        session.persist(game1);
        session.persist(game2);
        session.persist(game3);
        session.persist(game4);

        session.getTransaction().commit();
        session.close();
    }
}
