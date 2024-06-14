package com.ftn.sbnz.service.controllers;

import com.ftn.sbnz.service.services.RegularUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final RegularUserService regularUserService;

    @GetMapping(value = "/{userId}/recommendations")
    public ResponseEntity<?> getUserRecommendations(@PathVariable("userId") Long userId){
        return new ResponseEntity<>(regularUserService.getUserRecommendations(userId), HttpStatus.OK);
    }

}
