package com.metmwah.triviaparty.feature.score.entity;


import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class ScoreId implements Serializable {
    private int playerId;

    private int gameId;


    public ScoreId() {
    }

    public ScoreId(int playerId, int gameId) {
        this.playerId = playerId;
        this.gameId = gameId;
    }

}
