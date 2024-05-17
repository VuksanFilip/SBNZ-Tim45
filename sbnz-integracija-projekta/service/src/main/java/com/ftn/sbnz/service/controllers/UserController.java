package com.ftn.sbnz.service.controllers;

import com.ftn.sbnz.service.services.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

//    private final UserService userService;

    private final SongService songService;

//    @PutMapping(value = "/{userId}/listened-songs/{songId}")
//    public ResponseEntity<String> addToListenedSongs(@PathVariable("userId") Long userId, @PathVariable("songId") Long songId){
//        return new ResponseEntity<>(songService.addToListenedSongs(userId, songId), HttpStatus.OK);
//    }
//
//    @PutMapping(value = "/{userId}/favorite-songs/{songId}")
//    public ResponseEntity<String> addToFavoriteSongs(@PathVariable("userId") Long userId, @PathVariable("songId") Long songId){
//        return new ResponseEntity<>(songService.addToFavoriteSongs(userId, songId), HttpStatus.OK);
//    }

}
