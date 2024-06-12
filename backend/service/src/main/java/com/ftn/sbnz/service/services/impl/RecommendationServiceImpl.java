package com.ftn.sbnz.service.services.impl;

import com.ftn.sbnz.model.dtos.RecommendationDTO;
import com.ftn.sbnz.model.models.Recommendation;
import com.ftn.sbnz.model.models.RegularUser;
import com.ftn.sbnz.model.models.Song;
import com.ftn.sbnz.model.models.UserMood;
import com.ftn.sbnz.service.repositories.RecommendationRepository;
import com.ftn.sbnz.service.services.RecommendationService;
import com.ftn.sbnz.service.services.SongService;
import lombok.RequiredArgsConstructor;
import org.drools.template.DataProvider;
import org.drools.template.DataProviderCompiler;
import org.drools.template.objects.ArrayDataProvider;
import org.kie.api.KieBase;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RecommendationServiceImpl implements RecommendationService {

    private final RegularUserServiceImpl regularUserService;

    private final SongService songService;

    private final RecommendationRepository recommendationRepository;

    @Override
    public List<RecommendationDTO> getRecommendationForMood(Long userId, UserMood userMood) throws FileNotFoundException {
        RegularUser regularUser = regularUserService.findRegularUserById(userId);
        InputStream templateMoodRecommendations = new FileInputStream("D:/git/SBNZ-Tim45/backend/kjar/src/main/resources/rules/template/mood-recommendations-template.drt");

        DataProvider dataProvider = new ArrayDataProvider(new String[][] {
                {"Happy", "Happy", "Enjoy this uplifting song when you're happy!"},
                {"Sad", "Someone Like You", "This song might resonate with you when you're feeling down."},
                {"Energetic", "Eye of the Tiger", "Pump up your energy with this classic track!"},
                {"Relaxed", "Weightless", "Relax with this soothing ambient track."},
                {"Romantic", "Perfect", "Feel the love with this romantic song."},
                {"Motivated", "Lose Yourself", "Get motivated with this powerful anthem!"},
                {"Stressed", "Let It Be", "Find some peace with this calming tune."},
                {"Excited", "Uptown Funk", "Dance to this exciting and fun song!"},
                {"Adventurous", "On Top of the World", "Feel the spirit of adventure with this uplifting song."},
                {"Reflective", "Fix You", "Take some time to reflect with this introspective track."},
        });
        DataProviderCompiler converter = new DataProviderCompiler();
        String drlMoodRecommendations = converter.compile(dataProvider, templateMoodRecommendations);

        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(drlMoodRecommendations, ResourceType.DRL);

        KieBase kieBase = kieHelper.build();
        KieSession kieSession = kieBase.newKieSession();

        Set<Recommendation> recommendations = new HashSet<>();
        kieSession.setGlobal("recommendations", recommendations);

        kieSession.insert(userMood);
        for (Song s : songService.getAllSongs()) {
            kieSession.insert(s);
        }
        kieSession.insert(regularUser);

        kieSession.fireAllRules();
        kieSession.dispose();

        List<RecommendationDTO> recommendationDTOS = new ArrayList<>();
        for (Recommendation r : recommendations) {
            recommendationRepository.save(r);
            recommendationDTOS.add(RecommendationDTO.toRecommendationDTO(r));
        }
        return recommendationDTOS;
    }

}