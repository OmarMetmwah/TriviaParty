package com.metmwah.triviaparty.feature.score.entity;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
public class Score {
    @EmbeddedId
    private ScoreId scoreId;

    private int score;

    public Score(int playerId, int gameId) {
        this.scoreId = new ScoreId(playerId, gameId);
        score = 0;
    }
}
