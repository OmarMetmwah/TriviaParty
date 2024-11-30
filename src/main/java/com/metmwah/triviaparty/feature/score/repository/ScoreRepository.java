package com.metmwah.triviaparty.feature.score.repository;


import com.metmwah.triviaparty.feature.score.entity.Score;
import com.metmwah.triviaparty.feature.score.entity.ScoreId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {
    Optional<Score> findByScoreId(ScoreId scoreId);
    void deleteByScoreId(ScoreId scoreId);
}
