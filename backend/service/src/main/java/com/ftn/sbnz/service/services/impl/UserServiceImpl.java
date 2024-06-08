package com.ftn.sbnz.service.services.impl;

import com.ftn.sbnz.model.models.User;
import com.ftn.sbnz.model.dtos.RegistrationDTO;
import com.ftn.sbnz.model.dtos.UserDTO;
import com.ftn.sbnz.service.exceptions.BadRequestException;
import com.ftn.sbnz.service.exceptions.NotFoundException;
import com.ftn.sbnz.service.repositories.UserRepository;
import com.ftn.sbnz.service.services.UserPreferenceService;
import com.ftn.sbnz.service.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserPreferenceService userPreferenceService;

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

//        UserPreference userPreference = UserPreference.builder()
//                .user(user)
//                .build();
//        userPreferenceService.save(userPreference);

        return UserDTO.toUserDTO(user);
    }

    @Override
    public void checkIfExists(String username) {
        userRepository.findByUsername(username)
                .ifPresent(user -> {
                    throw new BadRequestException(String.format("User with username %s already exists!", user.getUsername()));
                });
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with email '%s'.", username));
        }
        return user;
    }
}