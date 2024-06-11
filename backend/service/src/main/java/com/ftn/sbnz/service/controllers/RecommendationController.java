package com.ftn.sbnz.service.controllers;

import com.ftn.sbnz.model.models.UserMood;
import com.ftn.sbnz.service.services.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    private final RecommendationService recommendationService;

    @PutMapping(value = "/{userId}/mood")
    public ResponseEntity<?> getRecommendationForMood(@PathVariable("userId") Long userId, @RequestBody UserMood userMood) throws FileNotFoundException {
        recommendationService.getRecommendationForMood(userId, userMood);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}