package com.ftn.sbnz.service.services.impl;

import com.ftn.sbnz.service.dtos.RecommendedSongDTO;
import com.ftn.sbnz.model.dtos.UserDTO;
import com.ftn.sbnz.service.repositories.ArtistRepository;
import com.ftn.sbnz.service.repositories.SongRepository;
import com.ftn.sbnz.service.services.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RecommendationServiceImpl implements RecommendationService {

    private final KieContainer kieContainer;

    private final SongRepository songRepository;

    private final ArtistRepository artistRepository;
    private final List<String> debugInfo = new ArrayList<>();


    @Override
    public Set<RecommendedSongDTO> getRecommendations(UserDTO userDTO) {
        Set<RecommendedSongDTO> recommendations = new HashSet<>();
        KieSession kieSession = kieContainer.newKieSession("fwKsession");

        kieSession.setGlobal("recommendations", recommendations);
        kieSession.insert(userDTO);
        kieSession.fireAllRules();
        kieSession.dispose();

        return recommendations;
    }

}