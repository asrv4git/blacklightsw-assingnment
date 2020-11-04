package com.blacklightsw.assignment.service;

import com.blacklightsw.assignment.models.dto.GameDto;
import com.blacklightsw.assignment.models.entity.Game;
import com.blacklightsw.assignment.repository.GameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service class for Game details
 *
 * @author Adarsh Srivastava
 */

@Service
public class GameService {

    private static final Logger log = LoggerFactory.getLogger(GameService.class);

    @Autowired
    GameRepository gameRepository;

    public GameDto fetchGameDataById(Long gameId) {
        try {
            Optional<Game> gameOptional = gameRepository.findGameByUserId(gameId);
            if (gameOptional.isPresent()) {
                Game game = gameOptional.get();
                GameDto gameDto = new GameDto(gameId,
                        game.getGamePlayedByUsers().stream()
                                .map(g -> g.getUserId())
                                .collect(Collectors.toList()),
                        new SimpleDateFormat("dd-MM-yyyy hh.mm aa") //format date-time as shown in image
                                .format(game.getStartTime()));
                return gameDto;
            } else {
                log.info("No game found with id: " + gameId);
                return null;
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            if (log.isDebugEnabled())
                e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
