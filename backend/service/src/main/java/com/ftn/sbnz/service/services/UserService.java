package com.ftn.sbnz.service.services;


import com.ftn.sbnz.model.models.User;
import com.ftn.sbnz.model.models.dtos.RegistrationDTO;
import com.ftn.sbnz.model.models.dtos.UserDTO;

import java.util.Optional;

public interface UserService {

    Optional<User> getByUsernameAndPassword(String username, String password);

    void add(User user);

    User findById(Long id);

    User save(User user);

    UserDTO register(RegistrationDTO registrationDTO);

    void checkIfExists(String username);

}
