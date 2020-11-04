package com.blacklightsw.assignment.service;

import com.blacklightsw.assignment.models.dto.UserDto;
import com.blacklightsw.assignment.models.entity.User;
import com.blacklightsw.assignment.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

/**
 * Service class for User details
 *
 * @author Adarsh Srivastava
 */

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    public UserDto fetchUserDataById(Long userId) {
        try {
            Optional<User> userOptional = userRepository.findUserByUserId(userId);
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                UserDto userDto = new UserDto(userId, user.getUserName(),
                        user.getGamesPlayed().size(),
                        user.getGamesWon().size(),
                        user.getLastGameId());
                return userDto;
            } else {
                log.info("No user found for id: " + userId);
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
