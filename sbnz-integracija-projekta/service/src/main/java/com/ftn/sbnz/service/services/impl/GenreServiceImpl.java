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
    public void basicBackward() {
        KieSession kieSession = kieContainer.newKieSession("bwKsession");

        kieSession.insert( new BackwardModel("Artist", "Album") );
        kieSession.insert( new BackwardModel("Album", "Song") );
        kieSession.insert( new BackwardModel("Song", "Genre") );

        kieSession.insert( "basic-backward" );
        kieSession.fireAllRules();
    }

    @Override
    public void findArtistGenre() {
        KieSession kieSession = kieContainer.newKieSession("bwKsession");

        kieSession.insert( new BackwardModel("Artist", "Album") );
        kieSession.insert( new BackwardModel("Album", "Song") );
        kieSession.insert( new BackwardModel("Song", "Genre") );

        kieSession.insert( "find-artist-genre" );
        kieSession.fireAllRules();
    }

    @Override
    public void findAlbumGenre() {
        KieSession kieSession = kieContainer.newKieSession("bwKsession");

        kieSession.insert( new BackwardModel("Artist", "Album") );
        kieSession.insert( new BackwardModel("Album", "Song") );
        kieSession.insert( new BackwardModel("Song", "Genre") );

        kieSession.insert( "find-album-genre" );
        kieSession.fireAllRules();
    }

}
