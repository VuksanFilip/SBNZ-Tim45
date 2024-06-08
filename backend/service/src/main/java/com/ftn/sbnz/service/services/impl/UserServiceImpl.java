package com.ftn.sbnz.service.services.impl;

import com.ftn.sbnz.model.models.User;
import com.ftn.sbnz.model.models.UserPreference;
import com.ftn.sbnz.model.models.dtos.RegistrationDTO;
import com.ftn.sbnz.model.models.dtos.UserDTO;
import com.ftn.sbnz.service.exceptions.BadRequestException;
import com.ftn.sbnz.service.exceptions.NotFoundException;
import com.ftn.sbnz.service.repositories.UserRepository;
import com.ftn.sbnz.service.services.UserPreferenceService;
import com.ftn.sbnz.service.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserPreferenceService userPreferenceService;

    @Override
    public Optional<User> getByUsernameAndPassword(String username, String password){
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public void add(User user){
        userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("User with id %s not found!", id)));
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public UserDTO register(RegistrationDTO registrationDTO) {
        checkIfExists(registrationDTO.getUsername());
        User newUser = User.builder()
                .username(registrationDTO.getUsername())
                .password(registrationDTO.getPassword())
                .build();
        User user = userRepository.save(newUser);

        UserPreference userPreference = UserPreference.builder()
                .user(user)
                .build();
        userPreferenceService.save(userPreference);

        return UserDTO.toUserDTO(user);
    }

    @Override
    public void checkIfExists(String username) {
        userRepository.findByUsername(username)
                .ifPresent(user -> {
                    throw new BadRequestException(String.format("User with username %s already exists!", user.getUsername()));
                });
    }

}