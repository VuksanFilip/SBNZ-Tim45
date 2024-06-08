package com.ftn.sbnz.service.controllers;

import com.ftn.sbnz.service.dtos.RecommendedSongDTO;
import com.ftn.sbnz.model.dtos.UserDTO;
import com.ftn.sbnz.service.services.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    private final RecommendationService recommendationService;

    @PutMapping()
    public ResponseEntity<Set<RecommendedSongDTO>> recommend(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(this.recommendationService.getRecommendations(userDTO), HttpStatus.OK);
    }
}