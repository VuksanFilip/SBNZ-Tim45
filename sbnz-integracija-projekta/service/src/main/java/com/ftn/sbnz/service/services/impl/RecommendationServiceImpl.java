package com.ftn.sbnz.service.services.impl;

import com.ftn.sbnz.model.Message;
import com.ftn.sbnz.model.models.Artist;
import com.ftn.sbnz.model.models.Song;
import com.ftn.sbnz.service.dtos.RecommendedSongDTO;
import com.ftn.sbnz.model.models.dtos.UserDTO;
import com.ftn.sbnz.service.repositories.ArtistRepository;
import com.ftn.sbnz.service.repositories.SongRepository;
import com.ftn.sbnz.service.repositories.UserRepository;
import com.ftn.sbnz.service.services.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

        Message message = new Message();
        message.setMessage("Hello World");
        message.setStatus(Message.HELLO);
        kieSession.setGlobal("recommendations", recommendations);
//        kieSession.insert(message);
        kieSession.insert(userDTO);
        kieSession.fireAllRules();
//        kieSession.setGlobal("recommendations", recommendations);
//        kieSession.insert(userDTO);
//
//        kieSession.fireAllRules();
//        kieSession.dispose();
//        System.out.println(recommendations.size());
//        return recommendations;
        return recommendations;
    }

}