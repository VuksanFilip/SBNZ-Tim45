package com.ftn.sbnz.service.controllers;

import com.ftn.sbnz.model.models.User;
import com.ftn.sbnz.service.dtos.LoginDTO;
import com.ftn.sbnz.service.exceptions.BadCredentialsException;
import com.ftn.sbnz.service.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping()
    public ResponseEntity<User> login(@RequestBody LoginDTO loginDTO, HttpSession session) {
        if(userService.getByUsernameAndPassword(loginDTO.username, loginDTO.password).isEmpty()){
            throw new BadCredentialsException("Bad credentials!");
        }
        User user = userService.getByUsernameAndPassword(loginDTO.username, loginDTO.password).get();
        session.setAttribute("user", user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
