package com.metmwah.triviaparty.feature.game.controller;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.util.UriComponentsBuilder;

public class SocketConnectionHandler extends TextWebSocketHandler {
    private final Map<String, Set<WebSocketSession>> games = new ConcurrentHashMap<>();
    private final Map<WebSocketSession, String> sessions = new ConcurrentHashMap<>();
    private final Map<String, String> playerGame = new ConcurrentHashMap<>();
    private final Map<String, Map> gameQuestions = new ConcurrentHashMap<>();
    private final Map<String, Integer> gameCurrentQuestion = new ConcurrentHashMap<>();
    private final Map<String, Integer> gameNumberOfAnswers = new ConcurrentHashMap<>();

    @Override
    public void
    afterConnectionEstablished(WebSocketSession session)
            throws Exception
    {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUri(session.getUri());
        String gameId = uriComponentsBuilder.build().getQueryParams().getFirst("gameId");
        String playerId = uriComponentsBuilder.build().getQueryParams().getFirst("playerId");

        games.computeIfAbsent(gameId, k -> new HashSet<>()).add(session);
        sessions.put(session, playerId);
        playerGame.put(playerId,gameId);


        var gameSessions = games.get(gameId);

        if(gameSessions.size() == 1){ // first player
            gameQuestions.put(gameId,TriviaDBThirdParty.getQuestions());
            gameCurrentQuestion.put(gameId, 1);
            gameNumberOfAnswers.put(gameId, 0);
        }


        for (WebSocketSession webSocketSession :
                gameSessions) {
            if (session == webSocketSession)
                continue;
            webSocketSession.sendMessage(new TextMessage(
                    "{\"type\":\"NewPlayer\",\"playerId\":\"" + playerId + "\"}"
            ));
        }

        session.sendMessage(new TextMessage(
                "{\"type\":\"Questions\",\"questions\":" + gameQuestions.get(gameId) + ",\"current_question\":"+ gameCurrentQuestion.get(gameId) + "\"}"
        ));

        super.afterConnectionEstablished(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session,
                                      CloseStatus status)throws Exception
    {
        String playerId = sessions.remove(session);
        String gameId = playerGame.get(playerId);

        games.get(gameId).remove(session);

        playerGame.remove(playerId);

        var gameSessions = games.get(gameId);

        for (WebSocketSession webSocketSession :
                gameSessions) {
            if (session == webSocketSession)
                continue;
            webSocketSession.sendMessage(new TextMessage(
                    "{\"type\":\"PlayerLeft\",\"playerId\":\"" + playerId + "\"}"
            ));
        }

        super.afterConnectionClosed(session, status);
    }

    @Override
    public void handleMessage(WebSocketSession session,
                              WebSocketMessage<?> message)
            throws Exception
    {
        super.handleMessage(session, message);
        // TODO: handle when receive answer increase number of answers and increase the current question and if last send scores

        var gameId = playerGame.get(sessions.get(session));
        var gameSessions = games.get(gameId);

        for (WebSocketSession webSocketSession :
                gameSessions) {
            if (session == webSocketSession)
                continue;
            webSocketSession.sendMessage(message);
        }
    }
}