package com.metmwah.triviaparty.feature.game.service;


public interface GameService {
    int create(int hostId);
    boolean check(int gameId);


}
