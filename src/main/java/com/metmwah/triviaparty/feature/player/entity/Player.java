package com.metmwah.triviaparty.feature.player.entity;


import com.metmwah.triviaparty.core.entity.BasicUser;
import com.metmwah.triviaparty.core.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Data
@Getter
@Setter
@Table(name = "Player")
public class Player extends BasicUser implements UserDetails {

    public Player(String email, String password) {
        super(email, password,Role.PLAYER);
    }

    public Player() {
        setRole( Role.PLAYER);
    }



}
