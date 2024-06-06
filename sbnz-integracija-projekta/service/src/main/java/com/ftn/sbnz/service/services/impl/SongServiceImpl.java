package com.ftn.sbnz.service.services.impl;

import com.ftn.sbnz.model.events.Event;
import com.ftn.sbnz.model.events.EventType;
import com.ftn.sbnz.model.models.Rating;
import com.ftn.sbnz.model.models.Song;
import com.ftn.sbnz.model.models.User;
import com.ftn.sbnz.model.models.UserPreference;
import com.ftn.sbnz.model.models.dtos.RatingDTO;
import com.ftn.sbnz.model.models.dtos.UserPreferenceDTO;
import com.ftn.sbnz.service.dtos.RecommendedSongDTO;
import com.ftn.sbnz.service.exceptions.BadRequestException;
import com.ftn.sbnz.model.models.dtos.SongDTO;
import com.ftn.sbnz.service.exceptions.NotFoundException;
import com.ftn.sbnz.service.repositories.EventRepository;
import com.ftn.sbnz.service.repositories.RatingRepository;
import com.ftn.sbnz.service.repositories.SongRepository;
import com.ftn.sbnz.service.services.SongService;
import com.ftn.sbnz.service.services.UserPreferenceService;
import com.ftn.sbnz.service.services.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    private final UserPreferenceService userPreferenceService;

    private final UserService userService;

    private final RatingRepository ratingRepository;

    private final KieContainer kieContainer;

    private final EventRepository eventRepository;

    @Override
    public Song findById(Long id) {
        return songRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Song with id %s not found!", id)));
    }

    @Override
    public Set<SongDTO> addToFavoriteSongs(Long userId, Long songId) {
        UserPreference userPreference = userPreferenceService.findByUserId(userId);
        List<Song> favoriteSongs = userPreference.getFavoriteSongs();

        Song song = findById(songId);

        for (Song favoriteSong : favoriteSongs) {
            if (favoriteSong.getId().equals(songId)){
                throw new BadRequestException(String.format("Song %s by %s is already in your favorites!", song.getName(), song.getArtist().getUsername()));
            }
        }

        favoriteSongs.add(song);
        userPreference.setFavoriteSongs(favoriteSongs);
        userPreferenceService.save(userPreference);

        Set<SongDTO> recommendations = new HashSet<>();
        KieSession kieSession = kieContainer.newKieSession("fwKsession");

        for(Song s: userPreference.getFavoriteSongs()){
            System.out.println("Favorite song " + s.getName());
        }
        System.out.println("Song " + song.getName());

        kieSession.setGlobal("recommendations", recommendations);
        kieSession.insert(song);
        kieSession.insert(userPreference);
        kieSession.fireAllRules();
        kieSession.dispose();

        return recommendations;
    }

    @Override
    public Set<SongDTO> addToListenedSongs(Long userId, Long songId) {
        UserPreference userPreference = userPreferenceService.findByUserId(userId);
        List<Song> listenedSongs = userPreference.getListenedSongs();

        Song song = findById(songId);

        boolean alreadyListened = false;

        for (Song listenedSong : listenedSongs) {
            if (listenedSong.getId().equals(songId)) {
                alreadyListened = true;
                break;
            }
        }

        if (!alreadyListened) {
            listenedSongs.add(song);
            userPreference.setListenedSongs(listenedSongs);
            userPreferenceService.save(userPreference);
        }

        Set<SongDTO> recommendations = new HashSet<>();
        KieSession kieSession = kieContainer.newKieSession("fwKsession");


        kieSession.setGlobal("recommendations", recommendations);
        kieSession.insert(song);
        kieSession.insert(userPreference);
        kieSession.fireAllRules();
        kieSession.dispose();

        return recommendations;
    }



    @Override
    public List<SongDTO> findAll() {
        return songRepository.findAll().stream()
                .map(SongDTO::toSongDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<SongDTO> findAllByArtist(Long artistId) {
        return songRepository.findAllByArtist_Id(artistId).stream()
                .map(SongDTO::toSongDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<SongDTO> findAllByGenre(Long genreId) {
        return songRepository.findAllByArtist_Id(genreId).stream()
                .map(SongDTO::toSongDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Set<SongDTO> rateSong(RatingDTO ratingDTO) {
        User user = userService.findById(ratingDTO.getRatedById());
        UserPreference userPreference = userPreferenceService.findByUserId(user.getId());
        List<Song> ratedSongs = userPreference.getRatedSongs();
        Song song = findById(ratingDTO.getSongId());

        Rating rating = Rating.builder()
                .ratedBy(user)
                .song(song)
                .rating(ratingDTO.getRating())
                .comment(ratingDTO.getComment())
                .build();

        for (Song s : ratedSongs) {
            if (s.getId().equals(song.getId())){
                throw new BadRequestException(String.format("Song %s by %s is already rated!", song.getName(), song.getArtist().getUsername()));
            }
        }

        ratingRepository.save(rating);
        ratedSongs.add(song);
        userPreference.setRatedSongs(ratedSongs);
        userPreferenceService.save(userPreference);

        Set<SongDTO> recommendations = new HashSet<>();
        KieSession kieSession = kieContainer.newKieSession("fwKsession");


        kieSession.setGlobal("recommendations", recommendations);
        kieSession.insert(song);
        kieSession.insert(rating);
        kieSession.insert(userPreference);
        kieSession.fireAllRules();
        kieSession.dispose();

        return recommendations;
    }

    @Override
    public List<Song> findAllSongs() {
        return songRepository.findAll();
    }

    @Override
    public void cepTry(Long id, Long userId) {
        User user = userService.findById(userId);
        Song listenedSong = findById(id);
        // rated
//        Rating rating = Rating.builder()
//                .ratedBy(user)
//                .song(listenedSong)
//                .rating(5)
//                .comment("top")
//                .build();
//        ratingRepository.save(rating);
//
//        Event event = Event.builder()
//                .executionTime(Date.from(Instant.now()))
//                .eventType(EventType.RATED)
//                .user(user)
//                .song(listenedSong)
//                .rating(rating)
//                .build();

        Event event = Event.builder()
                .executionTime(Date.from(Instant.now()))
                .eventType(EventType.FAVORITED)
                .user(user)
                .song(listenedSong)
                .build();
        eventRepository.save(event);

//        List<Event> events = user.getEvents();
        List<Event> events = eventRepository.findAll();
        List<Event> listenEvents = new ArrayList<>();
        for (Event e : events) {
            if (e.getEventType() == EventType.FAVORITED){
                listenEvents.add(e);
            }
        }

        KieSession kieSession = kieContainer.newKieSession("cepKsession");

        if (!listenEvents.isEmpty()){
            for (Event e : listenEvents){
                kieSession.insert(e);
            }
        }

        kieSession.fireAllRules();
        kieSession.dispose();
    }


}
