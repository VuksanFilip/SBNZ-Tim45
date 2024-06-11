package com.ftn.sbnz.service.services.impl;

import com.ftn.sbnz.model.dtos.RecommendationDTO;
import com.ftn.sbnz.model.events.Event;
import com.ftn.sbnz.model.events.EventType;
import com.ftn.sbnz.model.models.*;
import com.ftn.sbnz.model.dtos.RatingDTO;
import com.ftn.sbnz.service.exceptions.BadRequestException;
import com.ftn.sbnz.model.dtos.SongDTO;
import com.ftn.sbnz.service.exceptions.NotFoundException;
import com.ftn.sbnz.service.repositories.EventRepository;
import com.ftn.sbnz.service.repositories.RatingRepository;
import com.ftn.sbnz.service.repositories.RecommendationRepository;
import com.ftn.sbnz.service.repositories.SongRepository;
import com.ftn.sbnz.service.services.RegularUserService;
import com.ftn.sbnz.service.services.SongService;
import com.ftn.sbnz.service.services.UserPreferenceService;
import lombok.RequiredArgsConstructor;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    private final UserPreferenceService userPreferenceService;

    private final RegularUserService regularUserService;

    private final RatingRepository ratingRepository;

    private final KieContainer kieContainer;

    private final EventRepository eventRepository;

    private final RecommendationRepository recommendationRepository;

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

//        KieSession kieSession = kieContainer.newKieSession("fwKsession");
//
//
//        kieSession.setGlobal("recommendations", recommendations);
//        kieSession.insert(song);
//        kieSession.insert(rating);
//        kieSession.insert(userPreference);
//        kieSession.fireAllRules();
//        kieSession.dispose();


    @Override
    public List<Song> findAllSongs() {
        return songRepository.findAll();
    }

    @Override
    public Recommendation recommendSongsByGenre(int number, Genre genre, RegularUser user, String explanation) {
        List<Song> allSongs = songRepository.findAll();
        List<Song> nonListenedSongsByGenre = new ArrayList<>();
        List<Song> listenedSongs = user.getPreference().getListenedSongs();

        for (Song s : allSongs) {
            if (s.getGenre().equals(genre) && !listenedSongs.contains(s)) {
                nonListenedSongsByGenre.add(s);
            }
        }

        List<Song> recommendedSongs;
        if (nonListenedSongsByGenre.size() <= number) {
            recommendedSongs = nonListenedSongsByGenre;
        } else {
            Collections.shuffle(nonListenedSongsByGenre);
            recommendedSongs = nonListenedSongsByGenre.subList(0, number);
        }

        Recommendation recommendation = Recommendation.builder()
                .user(user)
                .explanation(explanation)
                .songs(new HashSet<>(recommendedSongs))
                .build();

        recommendationRepository.save(recommendation);

        return recommendation;
    }

    @Override
    public Recommendation recommendSongsByArtist(int number, Artist artist, RegularUser user, String explanation) {
        List<Song> allSongs = songRepository.findAll();
        List<Song> nonListenedSongsByGenre = new ArrayList<>();
        List<Song> listenedSongs = user.getPreference().getListenedSongs();

        for (Song s : allSongs) {
            if (s.getArtist().equals(artist) && !listenedSongs.contains(s)) {
                nonListenedSongsByGenre.add(s);
            }
        }

        List<Song> recommendedSongs;
        if (nonListenedSongsByGenre.size() <= number) {
            recommendedSongs = nonListenedSongsByGenre;
        } else {
            Collections.shuffle(nonListenedSongsByGenre);
            recommendedSongs = nonListenedSongsByGenre.subList(0, number);
        }

        Recommendation recommendation = Recommendation.builder()
                .user(user)
                .explanation(explanation)
                .songs(new HashSet<>(recommendedSongs))
                .build();

        recommendationRepository.save(recommendation);

        return recommendation;
    }

    @Override
    public List<RecommendationDTO> listenToSong(Long userId, Long songId) {
        Set<Recommendation> recommendations = new HashSet<>();
        RegularUser user = regularUserService.findRegularUserById(userId);
        UserPreference userPreference = user.getPreference();
        Song listenedSong = findById(songId);
        List<Song> listenedSongs = userPreference.getListenedSongs();
        listenedSongs.add(listenedSong);
        userPreferenceService.save(userPreference);

        Event event = createEvent(EventType.LISTENED, user, listenedSong, null);
        eventRepository.save(event);

        List<Event> events = eventRepository.findAll();

        KieSession kieSession = kieContainer.newKieSession("cepKsession");
        kieSession.setGlobal("songService", this);
        kieSession.setGlobal("recommendations", recommendations);

        if (!events.isEmpty()){
            for (Event e : events){
                kieSession.insert(e);
            }
        }

        kieSession.fireAllRules();
        kieSession.dispose();

        List<RecommendationDTO> recommendationDTOS = new ArrayList<>();
        if (!recommendations.isEmpty()) {
            for (Recommendation r : recommendations) {
                recommendationRepository.save(r);
                recommendationDTOS.add(RecommendationDTO.toRecommendationDTO(r));
            }
        }

        return recommendationDTOS;
    }

    @Override
    public List<RecommendationDTO> addRating(RatingDTO ratingDTO) {
        Set<Recommendation> recommendations = new HashSet<>();
        RegularUser user = regularUserService.findRegularUserById(ratingDTO.getRatedById());
        UserPreference userPreference = user.getPreference();
        Song ratedSong = findById(ratingDTO.getSongId());
        List<Song> ratedSongs = userPreference.getRatedSongs();
        ratedSongs.add(ratedSong);
        userPreferenceService.save(userPreference);

        Rating rating = Rating.builder()
                .ratedBy(user)
                .song(ratedSong)
                .rating(ratingDTO.getRating())
                .comment(ratingDTO.getComment())
                .build();
        ratingRepository.save(rating);

        Event event = createEvent(EventType.RATED, user, ratedSong, rating);
        eventRepository.save(event);

        List<Event> events = eventRepository.findAll();

        KieSession kieSession = kieContainer.newKieSession("cepKsession");
        kieSession.setGlobal("songService", this);
        kieSession.setGlobal("recommendations", recommendations);

        if (!events.isEmpty()){
            for (Event e : events){
                kieSession.insert(e);
            }
        }

        kieSession.fireAllRules();
        kieSession.dispose();

        List<RecommendationDTO> recommendationDTOS = new ArrayList<>();
        if (!recommendations.isEmpty()) {
            for (Recommendation r : recommendations) {
                recommendationRepository.save(r);
                recommendationDTOS.add(RecommendationDTO.toRecommendationDTO(r));
            }
        }

        return recommendationDTOS;
    }

    @Override
    public List<RecommendationDTO> findNewMusic(Long userId) {
        Set<Recommendation> recommendations = new HashSet<>();
        RegularUser user = regularUserService.findRegularUserById(userId);

        List<Event> events = eventRepository.findAll();

        KieSession kieSession = kieContainer.newKieSession("cepKsession");
        kieSession.setGlobal("songService", this);
        kieSession.setGlobal("recommendations", recommendations);
        kieSession.insert("newMusic");

        if (!events.isEmpty()){
            for (Event e : events){
                kieSession.insert(e);
            }
        }

        kieSession.fireAllRules();
        kieSession.dispose();

        List<RecommendationDTO> recommendationDTOS = new ArrayList<>();
        if (!recommendations.isEmpty()) {
            for (Recommendation r : recommendations) {
                r.setUser(user);
                recommendationRepository.save(r);
                recommendationDTOS.add(RecommendationDTO.toRecommendationDTO(r));
            }
        }

        return recommendationDTOS;
    }

    @Override
    public Recommendation recommendPopularSong(Song song) {
        Set<Song> songs = new HashSet<>();
        songs.add(song);
        return Recommendation.builder()
                .explanation("You might like these popular songs as much as other users!")
                .songs(songs)
                .build();
    }

    @Override
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    @Override
    public List<SongDTO> getUsersFavoriteSongs(Long userId) {
        RegularUser user = regularUserService.findRegularUserById(userId);
        return user.getPreference().getFavoriteSongs().stream()
                .map(SongDTO::toSongDTO)
                .collect(Collectors.toList());
    }

    private Event createEvent(EventType eventType, RegularUser user, Song song, Rating rating) {
        return Event.builder()
                .executionTime(Date.from(Instant.now()))
                .eventType(eventType)
                .user(user)
                .song(song)
                .rating(rating)
                .build();
    }

}
