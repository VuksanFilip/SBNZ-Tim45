package com.ftn.sbnz.service.services.impl;

import com.ftn.sbnz.model.models.User;
import com.ftn.sbnz.service.repositories.UserRepository;
import com.ftn.sbnz.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getByUsernameAndPassword(String username, String password){
        return this.userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public void add(User user){
        this.userRepository.save(user);
    }
}