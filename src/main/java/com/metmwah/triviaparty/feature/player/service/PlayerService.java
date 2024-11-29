package com.metmwah.triviaparty.feature.player.service;


import com.metmwah.triviaparty.core.dto.AuthResponseDTO;
import com.metmwah.triviaparty.core.dto.UserDTO;
import com.metmwah.triviaparty.core.dto.LoginRequestDTO;
import com.metmwah.triviaparty.core.dto.UserResponseDTO;


import java.util.List;

public interface PlayerService {
    AuthResponseDTO create(UserDTO userDto);

    AuthResponseDTO login(LoginRequestDTO loginRequestDTO);

    List<UserResponseDTO> get();
    UserResponseDTO get(Integer id);
    
    boolean checkUserExists(String email);
}
