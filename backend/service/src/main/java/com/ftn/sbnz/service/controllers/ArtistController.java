package com.ftn.sbnz.service.controllers;

import com.ftn.sbnz.model.dtos.ArtistDTO;
import com.ftn.sbnz.service.services.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/artists")
public class ArtistController {

    private final ArtistService artistService;

    @GetMapping
    public ResponseEntity<List<ArtistDTO>> getArtists(){
        return new ResponseEntity<>(artistService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/by-song/{songId}")
    public ResponseEntity<ArtistDTO> getArtistBySong(@PathVariable("songId") Long songId){
        return new ResponseEntity<>(artistService.findBySong(songId), HttpStatus.OK);
    }

    @GetMapping(value = "/by-genre/{genreId}")
    public ResponseEntity<ArtistDTO> getArtistByGenre(@PathVariable("genreId") Long genreId) {
        return new ResponseEntity<>(artistService.findByGenre(genreId), HttpStatus.OK);
    }
}
