package com.ftn.sbnz.service.controllers;

import com.ftn.sbnz.model.dtos.RegistrationDTO;
import com.ftn.sbnz.model.dtos.UserDTO;
import com.ftn.sbnz.service.services.SongService;
import com.ftn.sbnz.service.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    private final SongService songService;

    @PostMapping
    public ResponseEntity<UserDTO> register(@RequestBody RegistrationDTO registrationDTO){
        return new ResponseEntity<>(userService.register(registrationDTO), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{userId}/listened-songs/{songId}")
    public ResponseEntity<?> addToListenedSongs(@PathVariable("userId") Long userId, @PathVariable("songId") Long songId){
        return new ResponseEntity<>(songService.addToListenedSongs(userId, songId), HttpStatus.OK);
    }

    @PutMapping(value = "/{userId}/favorite-songs/{songId}")
    public ResponseEntity<?> addToFavoriteSongs(@PathVariable("userId") Long userId, @PathVariable("songId") Long songId){
        return new ResponseEntity<>(songService.addToFavoriteSongs(userId, songId), HttpStatus.OK);
    }

}
