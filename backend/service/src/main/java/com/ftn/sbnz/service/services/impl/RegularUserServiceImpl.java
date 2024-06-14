package com.ftn.sbnz.service.services.impl;

import com.ftn.sbnz.model.dtos.RecommendationDTO;
import com.ftn.sbnz.model.dtos.UserDTO;
import com.ftn.sbnz.model.models.RegularUser;
import com.ftn.sbnz.service.exceptions.NotFoundException;
import com.ftn.sbnz.service.repositories.RegularUserRepository;
import com.ftn.sbnz.service.services.RegularUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegularUserServiceImpl implements RegularUserService {

    private final RegularUserRepository regularUserRepository;

    @Override
    public UserDTO getUser(Long id) {
        return UserDTO.toUserDTO(findRegularUserById(id));
    }

    @Override
    public RegularUser findRegularUserById(Long id) {
        return regularUserRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("No regular user with id %s.", id)));
    }

    @Override
    public List<RecommendationDTO> getUserRecommendations(Long userId) {
        return findRegularUserById(userId).getRecommendations().stream()
                .map(RecommendationDTO::toRecommendationDTO)
                .collect(Collectors.toList());
    }

}
