package com.ftn.sbnz.service.controllers;

import com.ftn.sbnz.model.dtos.AuthenticationRequestDTO;
import com.ftn.sbnz.model.dtos.AuthenticationResponseDTO;
import com.ftn.sbnz.model.dtos.NewUserDTO;
import com.ftn.sbnz.model.dtos.UserDTO;
import com.ftn.sbnz.service.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "/register")
    public ResponseEntity<UserDTO> register(@RequestBody NewUserDTO newUserDTO){
        return new ResponseEntity<>(authService.register(newUserDTO), HttpStatus.CREATED);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<AuthenticationResponseDTO> register(@RequestBody AuthenticationRequestDTO authenticationRequestDTO){
        return new ResponseEntity<>(authService.login(authenticationRequestDTO), HttpStatus.OK);
    }

}
