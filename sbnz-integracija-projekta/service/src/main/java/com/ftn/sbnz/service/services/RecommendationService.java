package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.models.dtos.UserDTO;
import com.ftn.sbnz.service.dtos.RecommendedSongDTO;
//import com.ftn.sbnz.service.dtos.UserDTO;

import java.util.Set;

public interface RecommendationService {

    Set<RecommendedSongDTO> getRecommendations(UserDTO userDTO);

}
