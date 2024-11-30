package com.metmwah.triviaparty.feature.score.controller;

import com.metmwah.triviaparty.core.constants.Endpoints;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Endpoints.PLAYER_ENDPOINT)
@RequiredArgsConstructor
public class ScoreController {

//    private final PlayerService playerService;
//
//    @PostMapping("/register")
//    public ResponseEntity register(@RequestBody UserDTO userDTO) {
//        return ResponseEntity.status(HttpStatus.CREATED).body(playerService.create(userDTO));
//    }
//    @PostMapping("/login")
//    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
//        return ResponseEntity.status(HttpStatus.OK).body(playerService.login(loginRequestDTO));
//    }
//
//
//    @GetMapping
//    public ResponseEntity<List<UserResponseDTO>> get() {
//        return ResponseEntity.status(HttpStatus.OK).body(playerService.get());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<UserResponseDTO> get(@PathVariable Integer id) {
//        return ResponseEntity.status(HttpStatus.OK).body(playerService.get(id));
//    }
}
