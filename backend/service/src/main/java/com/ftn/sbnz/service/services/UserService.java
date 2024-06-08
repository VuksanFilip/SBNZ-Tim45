package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.models.User;
import com.ftn.sbnz.model.dtos.RegistrationDTO;
import com.ftn.sbnz.model.dtos.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void add(User user);

    User findById(Long id);

    User save(User user);

    UserDTO register(RegistrationDTO registrationDTO);

    void checkIfExists(String username);

}
