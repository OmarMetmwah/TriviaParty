package com.metmwah.triviaparty.feature.score.service;


public interface ScoreService {
    void create(int playerId,int gameId);
    void delete(int playerId,int gameId);
    boolean check(int playerId,int gameId);
}
