package com.blacklightsw.assignment.controller;

import com.blacklightsw.assignment.models.dto.GameDto;
import com.blacklightsw.assignment.models.dto.UserDto;
import com.blacklightsw.assignment.service.GameService;
import com.blacklightsw.assignment.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Main Rest controller of API
 *
 * @author Adarsh Srivastava
 */

@RestController
@RequestMapping("/api/v1")
@Api(value = "Fetch Details", description = "Game API v1")
public class ApiRestController {

    @Autowired
    UserService userService;

    @Autowired
    GameService gameService;

    @GetMapping("details/user/{userId}")
    @ApiOperation("Get user details by ID. Following ID's can be used to fetch" +
            " details for user. UserIDs: 1001, 1002, 1003, 1004.")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId) {
        if (userId == null)
            return ResponseEntity.badRequest().body(null);
        else {
            UserDto userDto = userService.fetchUserDataById(userId);
            return ResponseEntity.ok(userDto);
        }
    }

    @GetMapping("details/game/{gameId}")
    @ApiOperation("Get game/match details by ID. Following ID's can be used to" +
            " fetch details for Match. GameIDs: 50001, 50002, 50003, 50004")
    public ResponseEntity<GameDto> getGameById(@PathVariable Long gameId) {
        if (gameId == null)
            return ResponseEntity.badRequest().body(null);
        else {
            GameDto gameDto = gameService.fetchGameDataById(gameId);
            return ResponseEntity.ok(gameDto);
        }
    }
}
