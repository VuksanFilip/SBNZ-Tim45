package com.ftn.sbnz.service.services.impl;

import com.ftn.sbnz.model.BackwardModel;
import com.ftn.sbnz.service.services.GenreService;
import lombok.RequiredArgsConstructor;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final KieContainer kieContainer;

    @Override
    public void backwardModel() {
        KieSession kieSession = kieContainer.newKieSession("bwKsession");

        kieSession.insert( new BackwardModel("Artist", "Album") );
        kieSession.insert( new BackwardModel("Album", "Song") );
        kieSession.insert( new BackwardModel("Song", "Genre") );

        kieSession.insert( "backward-rule" );
        kieSession.fireAllRules();
    }

}
