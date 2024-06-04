package com.ftn.sbnz.service.controllers;

import com.ftn.sbnz.model.models.dtos.RatingDTO;
import com.ftn.sbnz.model.models.dtos.SongDTO;
import com.ftn.sbnz.service.services.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/songs")
public class SongController {

    private final SongService songService;

    @GetMapping
    public ResponseEntity<List<SongDTO>> getSongs(){
        return new ResponseEntity<>(songService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/by-artist/{artistId}")
    public ResponseEntity<List<SongDTO>> getSongsByArtist(@PathVariable("artistId") Long artistId){
        return new ResponseEntity<>(songService.findAllByArtist(artistId), HttpStatus.OK);
    }

    @GetMapping(value = "/by-genre/{genreId}")
    public ResponseEntity<List<SongDTO>> getSongsByGenre(@PathVariable("genreId") Long genreId){
        return new ResponseEntity<>(songService.findAllByGenre(genreId), HttpStatus.OK);
    }

    @PostMapping(value = "/rating")
    public ResponseEntity<?> rateSong(@RequestBody RatingDTO ratingDTO){
        return new ResponseEntity<>(songService.rateSong(ratingDTO), HttpStatus.OK);
    }

    @GetMapping(value = "/cep/{id}")
    public ResponseEntity<?> cepTry(@PathVariable("id") Long id){
        songService.cepTry(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
