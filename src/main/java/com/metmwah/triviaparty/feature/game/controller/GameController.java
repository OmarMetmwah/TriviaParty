package com.metmwah.triviaparty.feature.game.controller;

import com.metmwah.triviaparty.core.constants.Endpoints;
import com.metmwah.triviaparty.feature.game.service.GameService;
import com.metmwah.triviaparty.feature.player.service.PlayerService;
import com.metmwah.triviaparty.feature.score.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Endpoints.GAME_ENDPOINT)
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;
    private final PlayerService playerService;
    private final ScoreService scoreService;


    @PostMapping
    public ResponseEntity<Integer> createRoom(Authentication authentication) {
        return ResponseEntity.status(HttpStatus.CREATED).body(gameService.create(playerService.get(authentication.getName())));
    }

    @PostMapping("/{gameCode}/join")
    public ResponseEntity joinRoom(@PathVariable Integer gameCode, Authentication authentication) {
        if (gameService.check(gameCode)) {
            if (scoreService.check(playerService.get(authentication.getName()), gameCode)) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("You have already joined this game");
            } else {
                scoreService.create(playerService.get(authentication.getName()), gameCode);
                return ResponseEntity.status(HttpStatus.CREATED).body(null);
            }

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There is no Existing game with code: " + gameCode);
        }
    }

}

