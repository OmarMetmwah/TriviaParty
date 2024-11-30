package com.metmwah.triviaparty.feature.game.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class TriviaDBThirdParty {
    static private RestTemplate restTemplate;
    static private String url = "https://opentdb.com/api.php?amount=10";


    public TriviaDBThirdParty(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    static public Map<String, Object> getQuestions() {
        return restTemplate.getForObject(url,Map.class);
    }

}
