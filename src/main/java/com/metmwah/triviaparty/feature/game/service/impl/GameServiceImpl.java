package com.metmwah.triviaparty.feature.game.service.impl;

import com.metmwah.triviaparty.core.mapper.UserMapper;
import com.metmwah.triviaparty.feature.game.entity.Game;
import com.metmwah.triviaparty.feature.game.repository.GameRepository;
import com.metmwah.triviaparty.feature.game.service.GameService;
import com.metmwah.triviaparty.feature.score.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final ScoreService scoreService;


    private final UserMapper mapper;

    @Transactional
    @Override
    public int create(int hostId) {
        Game game = gameRepository.save(new Game());
        scoreService.create(hostId,game.getId());
        return game.getId();
    }

    @Transactional
    @Override
    public boolean check(int gameId) {
        return gameRepository.findById(gameId).isPresent();
    }

}
