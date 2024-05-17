package com.ftn.sbnz.service.services.impl;

import com.ftn.sbnz.model.models.UserPreference;
import com.ftn.sbnz.service.exceptions.NotFoundException;
import com.ftn.sbnz.service.repositories.UserPreferenceRepository;
import com.ftn.sbnz.service.services.UserPreferenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserPreferenceServiceImpl implements UserPreferenceService {

    private final UserPreferenceRepository userPreferenceRepository;

    @Override
    public UserPreference findByUserId(Long userId) {
        return userPreferenceRepository.findByUserId(userId)
                .orElseThrow(() -> new NotFoundException(String.format("User preference for user with id %s not found!", userId)));
    }

    @Override
    public UserPreference save(UserPreference userPreference) {
        return userPreferenceRepository.save(userPreference);
    }

}
