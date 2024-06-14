package com.ftn.sbnz.service.services.impl;

import com.ftn.sbnz.model.dtos.AuthenticationRequestDTO;
import com.ftn.sbnz.model.dtos.AuthenticationResponseDTO;
import com.ftn.sbnz.model.dtos.NewUserDTO;
import com.ftn.sbnz.model.dtos.UserDTO;
import com.ftn.sbnz.model.models.Artist;
import com.ftn.sbnz.model.models.RegularUser;
import com.ftn.sbnz.model.models.User;
import com.ftn.sbnz.model.models.UserPreference;
import com.ftn.sbnz.model.models.enums.Role;
import com.ftn.sbnz.service.config.TokenUtils;
import com.ftn.sbnz.service.repositories.ArtistRepository;
import com.ftn.sbnz.service.repositories.RegularUserRepository;
import com.ftn.sbnz.service.services.AuthService;
import com.ftn.sbnz.service.services.UserPreferenceService;
import com.ftn.sbnz.service.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;

    private final UserPreferenceService userPreferenceService;

    private final RegularUserRepository regularUserRepository;

    private final ArtistRepository artistRepository;

    private final TokenUtils tokenUtils;

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthenticationResponseDTO login(AuthenticationRequestDTO requestDTO) {
        String requestUsername = requestDTO.getUsername();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        requestUsername,
                        requestDTO.getPassword()
                )
        );
        User user = userService.findByUsername(requestUsername);
        return AuthenticationResponseDTO.builder()
                .token(tokenUtils.generateToken(user))
                .refreshToken(tokenUtils.generateRefreshToken(user))
                .build();
    }

    @Override
    public UserDTO register(NewUserDTO newUserDTO) {
        userService.checkIfExists(newUserDTO.getUsername());
        User newUser = User.builder()
                .username(newUserDTO.getUsername())
                .password(passwordEncoder.encode(newUserDTO.getPassword()))
                .firstName(newUserDTO.getFirstName())
                .lastName(newUserDTO.getLastName())
                .role(newUserDTO.getRole())
                .build();

        if (newUser.getRole() == Role.REGULAR_USER) {
            RegularUser regularUser = new RegularUser();
            regularUser.setId(newUser.getId());
            regularUser.setUsername(newUser.getUsername());
            regularUser.setPassword(newUser.getPassword());
            regularUser.setFirstName(newUser.getFirstName());
            regularUser.setLastName(newUser.getLastName());
            regularUser.setRole(newUser.getRole());
            regularUserRepository.save(regularUser);

            UserPreference userPreference = UserPreference.builder()
                    .user(regularUser)
                    .build();
            userPreferenceService.save(userPreference);
        } else if (newUser.getRole() == Role.ARTIST) {
            Artist artist = new Artist();
            artist.setId(newUser.getId());
            artist.setUsername(newUser.getUsername());
            artist.setPassword(newUser.getPassword());
            artist.setFirstName(newUser.getFirstName());
            artist.setLastName(newUser.getLastName());
            artist.setRole(newUser.getRole());
            artistRepository.save(artist);
        }

        return UserDTO.toUserDTO(newUser);
    }


}
