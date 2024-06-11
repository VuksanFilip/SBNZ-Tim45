package com.ftn.sbnz.service.controllers;

import com.ftn.sbnz.model.dtos.FavoriteSongDTO;
import com.ftn.sbnz.model.dtos.RatingDTO;
import com.ftn.sbnz.model.dtos.SongDTO;
import com.ftn.sbnz.service.services.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

//    @PostMapping(value = "/rating")
//    public ResponseEntity<?> rateSong(@RequestBody RatingDTO ratingDTO){
//        return new ResponseEntity<>(songService.rateSong(ratingDTO), HttpStatus.OK);
//    }

    @PutMapping(value = "/{userId}/listen/{songId}")
    public ResponseEntity<?> listenToSong(@PathVariable("userId") Long userId, @PathVariable("songId") Long songId) {
        return new ResponseEntity<>(songService.listenToSong(userId, songId), HttpStatus.OK);
    }

    @PutMapping(value = "/rating")
    public ResponseEntity<?> addRating(@RequestBody RatingDTO ratingDTO) {
        return new ResponseEntity<>(songService.addRating(ratingDTO), HttpStatus.OK);
    }

    @PutMapping(value = "/favorite")
    @PreAuthorize("hasAuthority('REGULAR_USER')")
    public ResponseEntity<?> addFavoriteSong(@RequestBody FavoriteSongDTO favoritceSongDTO) {
        return new ResponseEntity<>(songService.addToFavoriteSongs(favoritceSongDTO), HttpStatus.OK);
    }

    @GetMapping(value = "/{userId}/new-music")
    public ResponseEntity<?> findNewMusic(@PathVariable("userId") Long userId) {
        return new ResponseEntity<>(songService.findNewMusic(userId), HttpStatus.OK);
    }

}
