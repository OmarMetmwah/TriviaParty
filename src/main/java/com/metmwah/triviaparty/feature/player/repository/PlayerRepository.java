package com.metmwah.triviaparty.feature.player.repository;


import com.metmwah.triviaparty.feature.player.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    Optional<Player> findByEmail(String email);
}
