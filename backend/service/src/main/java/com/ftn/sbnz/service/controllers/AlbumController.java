package com.ftn.sbnz.service.controllers;

import com.ftn.sbnz.model.dtos.AlbumDTO;
import com.ftn.sbnz.service.services.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    private final AlbumService albumService;

    @GetMapping(value = "/by-song/{songId}")
    public ResponseEntity<AlbumDTO> getAlbumBySong(@PathVariable("songId") Long songId){
        return new ResponseEntity<>(albumService.findBySong(songId), HttpStatus.OK);
    }

    @GetMapping(value = "/by-artist/{artistId}")
    public ResponseEntity<AlbumDTO> getAlbumByArtist(@PathVariable("artistId") Long artistId){
        return new ResponseEntity<>(albumService.findByArtist(artistId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllAlbums(){
        return new ResponseEntity<>(albumService.findAllAlbumDTOs(), HttpStatus.OK);
    }

}
