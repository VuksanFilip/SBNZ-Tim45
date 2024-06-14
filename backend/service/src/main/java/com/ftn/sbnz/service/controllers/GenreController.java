package com.ftn.sbnz.service.controllers;

import com.ftn.sbnz.model.dtos.GenreDTO;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.ftn.sbnz.service.services.GenreService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/genres")
public class GenreController {

    private final GenreService genreService;

    @PostMapping(value = "/{id}/genre")
    @PreAuthorize("hasAuthority('ARTIST')")
    public ResponseEntity<?> setArtistGenre(@PathVariable("id") Long id, GenreDTO genreDTO) {
        genreService.setArtistGenre(id, genreDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
