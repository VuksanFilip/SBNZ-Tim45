package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void add(User user);

    User findById(Long id);

    User save(User user);

    void checkIfExists(String username);

    User findByUsername(String username);

}
