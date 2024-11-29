package com.metmwah.triviaparty.feature.player.controller;

import com.metmwah.triviaparty.core.constants.Endpoints;
import com.metmwah.triviaparty.core.dto.AuthResponseDTO;
import com.metmwah.triviaparty.core.dto.UserDTO;
import com.metmwah.triviaparty.core.dto.LoginRequestDTO;
import com.metmwah.triviaparty.core.dto.UserResponseDTO;
import com.metmwah.triviaparty.core.exception.UserAlreadyExistsException;
import com.metmwah.triviaparty.feature.player.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Endpoints.PLAYER_ENDPOINT)
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserDTO userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(playerService.create(userDTO));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(playerService.login(loginRequestDTO));
    }


    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> get() {
        return ResponseEntity.status(HttpStatus.OK).body(playerService.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> get(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(playerService.get(id));
    }
}
