package com.metmwah.triviaparty.feature.player.service.impl;

import com.metmwah.triviaparty.core.dto.AuthResponseDTO;
import com.metmwah.triviaparty.core.dto.LoginRequestDTO;
import com.metmwah.triviaparty.core.dto.UserDTO;
import com.metmwah.triviaparty.core.dto.UserResponseDTO;
import com.metmwah.triviaparty.core.exception.NotFoundException;
import com.metmwah.triviaparty.core.exception.UserAlreadyExistsException;
import com.metmwah.triviaparty.core.exception.WrongCredentialsException;
import com.metmwah.triviaparty.core.mapper.UserMapper;
import com.metmwah.triviaparty.core.service.JwtService;
import com.metmwah.triviaparty.feature.player.entity.Player;
import com.metmwah.triviaparty.feature.player.repository.PlayerRepository;
import com.metmwah.triviaparty.feature.player.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;


    private final UserMapper mapper;

    @Transactional
    @Override
    public AuthResponseDTO create(UserDTO userDto) {
        Player user = mapper.userDtoToPlayer(userDto);

        if (playerRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException(user.getEmail());
        }
        String encryptedPassword = passwordEncoder.encode(userDto.getPassword());
        user.setPassword(encryptedPassword);


        user = playerRepository.save(user);
        return constructAuthResponse(user);
    }

    @Transactional
    @Override
    public AuthResponseDTO login(LoginRequestDTO loginRequestDTO) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getEmail(), loginRequestDTO.getPassword()));
        } catch (Exception e) {
            throw new WrongCredentialsException();
        }
        String email = loginRequestDTO.getEmail();
        return constructAuthResponse(email);
    }


    @Transactional
    @Override
    public List<UserResponseDTO> get() {
        List<UserResponseDTO> userResponseDTOS = new ArrayList<>();
        playerRepository.findAll().forEach(user -> userResponseDTOS.add( mapper.playerToUserResponseDTO(user)));
        return userResponseDTOS;
    }

    @Transactional
    @Override
    public UserResponseDTO get(Integer id) {
        return mapper.playerToUserResponseDTO(playerRepository.findById(id).orElseThrow(() -> new NotFoundException("user",id.toString())));
    }

    @Override
    public boolean checkUserExists(String email) {
        return playerRepository.findByEmail(email).isPresent();
    }


    private AuthResponseDTO constructAuthResponse(String username) {
        Player user = playerRepository.findByEmail(username).orElseThrow(() -> new WrongCredentialsException());

        return constructAuthResponse(user);
    }

    private AuthResponseDTO constructAuthResponse(Player user) {
        String jwt = jwtService.generateToken(user);
        AuthResponseDTO userToAuthResponseDTO = mapper.userToAuthResponseDTO(user);
        userToAuthResponseDTO.setToken(jwt);

        return userToAuthResponseDTO;
    }
}
