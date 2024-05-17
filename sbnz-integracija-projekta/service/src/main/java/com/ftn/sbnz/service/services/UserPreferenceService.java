package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.models.UserPreference;

public interface UserPreferenceService {

    UserPreference findByUserId(Long userId);

    UserPreference save(UserPreference userPreference);

}
