package com.metmwah.triviaparty.feature.website.controller;

import com.metmwah.triviaparty.core.constants.Endpoints;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(Endpoints.WEBSITE_ENDPOINT)
@RequiredArgsConstructor
public class WebsiteController {
    @GetMapping
    public ResponseEntity<String> get() {
        return ResponseEntity.status(HttpStatus.OK).body("TriviaParty API is running!");
    }
}