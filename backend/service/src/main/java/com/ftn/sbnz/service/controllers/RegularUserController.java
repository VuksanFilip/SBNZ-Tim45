package com.ftn.sbnz.service.controllers;

import com.ftn.sbnz.service.services.RegularUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/regular-users")
public class RegularUserController {

    private final RegularUserService regularUserService;

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('REGULAR_USER')")
    public ResponseEntity<?> getRegularUserById(@PathVariable("id") Long id ) {
        return new ResponseEntity<>(regularUserService.getUser(id), HttpStatus.OK);
    }

}
