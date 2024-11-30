package com.metmwah.triviaparty.feature.game.repository;


import com.metmwah.triviaparty.feature.game.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
    Optional<Game> findById(int gameId);
}
