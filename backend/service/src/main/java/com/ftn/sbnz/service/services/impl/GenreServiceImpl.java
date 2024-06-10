package com.ftn.sbnz.service.services.impl;

import com.ftn.sbnz.model.BackwardModel;
import com.ftn.sbnz.model.dtos.GenreDTO;
import com.ftn.sbnz.model.models.Album;
import com.ftn.sbnz.model.models.Artist;
import com.ftn.sbnz.model.models.Genre;
import com.ftn.sbnz.model.models.Song;
import com.ftn.sbnz.service.repositories.GenreRepository;
import com.ftn.sbnz.service.services.AlbumService;
import com.ftn.sbnz.service.services.ArtistService;
import com.ftn.sbnz.service.services.GenreService;
import com.ftn.sbnz.service.services.SongService;
import lombok.RequiredArgsConstructor;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final KieContainer kieContainer;

    private final GenreRepository genreRepository;

    private final ArtistService artistService;

    private final AlbumService albumService;

    private final SongService songService;

    @Override
    public List<Genre> findAllGenres() {
        return genreRepository.findAll();
    }

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

    @Override
    public void findSimilarArtists() {
        KieSession kieSession = createKieSessionWithData();

        kieSession.insert( "find-similar-artists" );
        kieSession.fireAllRules();
    }

    @Override
    public Genre findGenreByName(String name) {
        return genreRepository.findByGenre(name).orElse(null);
    }

    @Override
    public void setArtistGenre(Long id, GenreDTO genre) {
        Artist artist = artistService.findArtistById(id);
        Genre foundGenre = findGenreByName(genre.getGenre());
        if (foundGenre == null) {
            Genre newGenre = Genre.builder()
                    .genre(genre.getGenre())
                    .build();
            Genre savedGenre = save(newGenre);
            artist.setGenre(savedGenre);
        }
        artist.setGenre(foundGenre);
    }

    @Override
    public Genre save(Genre genre) {
        return genreRepository.save(genre);
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
