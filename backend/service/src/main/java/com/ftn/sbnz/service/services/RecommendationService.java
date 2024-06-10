package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.models.UserMood;

import java.io.FileNotFoundException;

public interface RecommendationService {

    void getRecommendationForMood(Long userId, UserMood userMood) throws FileNotFoundException;

}
