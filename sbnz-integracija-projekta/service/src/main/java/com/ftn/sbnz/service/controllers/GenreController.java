package com.ftn.sbnz.service.controllers;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.sbnz.service.services.GenreService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/genres")
public class GenreController {

    private final GenreService genreService;

    @GetMapping
    public ResponseEntity<?> backwardModel(){
        genreService.backwardModel();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
