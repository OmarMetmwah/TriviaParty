package com.metmwah.triviaparty.core.mapper;


import com.metmwah.triviaparty.core.dto.AuthResponseDTO;
import com.metmwah.triviaparty.core.dto.UserDTO;
import com.metmwah.triviaparty.core.dto.UserResponseDTO;
import com.metmwah.triviaparty.feature.player.entity.Player;
import org.mapstruct.Mapper;


@Mapper( componentModel = "spring")
public interface UserMapper {
    Player userDtoToPlayer(UserDTO userDTO);

    UserResponseDTO playerToUserResponseDTO(Player player);

    AuthResponseDTO userToAuthResponseDTO(Player player);
}
