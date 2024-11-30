package com.metmwah.triviaparty.feature.score.service.impl;

import com.metmwah.triviaparty.feature.score.entity.Score;
import com.metmwah.triviaparty.feature.score.entity.ScoreId;
import com.metmwah.triviaparty.feature.score.repository.ScoreRepository;
import com.metmwah.triviaparty.feature.score.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScoreServiceImpl implements ScoreService {

    private final ScoreRepository scoreRepository;

    @Transactional
    @Override
    public void create(int playerId,int gameId) {
        scoreRepository.save(new Score(playerId,gameId));
    }

    @Transactional
    @Override
    public void delete(int playerId,int gameId) {
        scoreRepository.deleteByScoreId( new ScoreId(playerId,gameId));
    }

    @Transactional
    @Override
    public boolean check(int playerId,int gameId) {
        return scoreRepository.findByScoreId(new ScoreId(playerId,gameId)).isPresent();
    }
}
