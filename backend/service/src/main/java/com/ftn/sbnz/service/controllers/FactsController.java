package com.ftn.sbnz.service.controllers;

import com.ftn.sbnz.service.services.FactsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/facts")
public class FactsController {

    private final FactsService factsService;

    @GetMapping(value = "/{artistId}/artist-facts")
    public ResponseEntity<?> findArtistFacts(@PathVariable("artistId") Long artistId){
        return new ResponseEntity<>(factsService.findArtistFacts(artistId), HttpStatus.OK);
    }

    @GetMapping(value = "/{albumId}/album-facts")
    public ResponseEntity<?> findAlbumFacts(@PathVariable("albumId") Long albumId){
        return new ResponseEntity<>(factsService.findAlbumFacts(albumId), HttpStatus.OK);
    }

    @GetMapping(value = "/{songId}/song-facts")
    public ResponseEntity<?> findSongFacts(@PathVariable("songId") Long songId){
        return new ResponseEntity<>(factsService.findSongFacts(songId), HttpStatus.OK);
    }

}
