package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.dtos.RecommendationDTO;
import com.ftn.sbnz.model.models.UserMood;

import java.io.FileNotFoundException;
import java.util.List;

public interface RecommendationService {

    List<RecommendationDTO> getRecommendationForMood(Long userId, UserMood userMood) throws FileNotFoundException;

}
