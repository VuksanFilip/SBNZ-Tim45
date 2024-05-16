package com.ftn.sbnz.service.services;


import com.ftn.sbnz.model.models.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getByUsernameAndPassword(String username, String password);

    void add(User user);
}
