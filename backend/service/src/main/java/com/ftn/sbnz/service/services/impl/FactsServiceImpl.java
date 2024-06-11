package com.ftn.sbnz.service.services.impl;

import com.ftn.sbnz.model.BackwardModel;
import com.ftn.sbnz.model.models.Album;
import com.ftn.sbnz.model.models.Artist;
import com.ftn.sbnz.model.models.Song;
import com.ftn.sbnz.service.services.AlbumService;
import com.ftn.sbnz.service.services.ArtistService;
import com.ftn.sbnz.service.services.FactsService;
import com.ftn.sbnz.service.services.SongService;
import lombok.RequiredArgsConstructor;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class FactsServiceImpl implements FactsService {

    private final KieContainer kieContainer;

    private final AlbumService albumService;

    private final SongService songService;

    private final ArtistService artistService;

    @Override
    public Set<String> findArtistFacts(Long id) {
        KieSession kieSession = createKieSessionWithData();

        Set<String> facts = new HashSet<>();
        kieSession.setGlobal("facts", facts);

        kieSession.insert(artistService.findArtistById(id));
        kieSession.insert( "artist-facts" );

        kieSession.fireAllRules();

        return facts;
    }

    @Override
    public Set<String> findAlbumFacts(Long id) {
        KieSession kieSession = createKieSessionWithData();

        Set<String> facts = new HashSet<>();
        kieSession.setGlobal("facts", facts);

        kieSession.insert(albumService.findById(id));
        kieSession.insert( "album-facts" );

        kieSession.fireAllRules();

        return facts;
    }

    @Override
    public Set<String> findSongFacts(Long songId) {
        KieSession kieSession = createKieSessionWithData();

        Set<String> facts = new HashSet<>();
        kieSession.setGlobal("facts", facts);

        kieSession.insert(songService.findById(songId));
        kieSession.insert( "song-facts" );

        kieSession.fireAllRules();

        return facts;
    }

    private KieSession createKieSessionWithData() {
        KieSession kieSession = kieContainer.newKieSession("bwKsession");
        for (Artist artist : artistService.findAllArtists()){
            for (Album album : artist.getAlbums()){
                kieSession.insert( new BackwardModel(artist.getUsername(), album.getTitle()) );
            }
        }

        for (Album album : albumService.findAllAlbums()){
            for (Song song : album.getSongs()){
                kieSession.insert( new BackwardModel(album.getTitle(), song.getName()) );
            }
        }

        for (Song song : songService.findAllSongs()){
            kieSession.insert( new BackwardModel(song.getName(), song.getGenre().getGenre()) );
        }

        return kieSession;
    }

}
