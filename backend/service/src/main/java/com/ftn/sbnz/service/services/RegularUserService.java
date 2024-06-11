package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.dtos.RecommendationDTO;
import com.ftn.sbnz.model.dtos.UserDTO;
import com.ftn.sbnz.model.models.RegularUser;

import java.util.List;

public interface RegularUserService {

    UserDTO getUser(Long id);

    RegularUser findRegularUserById(Long id);

    List<RecommendationDTO> getUserRecommendations(Long userId);
}
