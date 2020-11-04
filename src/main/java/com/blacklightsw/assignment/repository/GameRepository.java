package com.blacklightsw.assignment.repository;

import com.blacklightsw.assignment.models.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    @Query("select g from Game g where g.gameId = :gameId")
    Optional<Game> findGameByUserId(@Param("gameId") Long gameId);
}
