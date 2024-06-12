package com.ftn.sbnz.service.services.impl;

import com.ftn.sbnz.model.dtos.FavoriteSongDTO;
import com.ftn.sbnz.model.dtos.RecommendationDTO;
import com.ftn.sbnz.model.events.Event;
import com.ftn.sbnz.model.events.EventType;
import com.ftn.sbnz.model.models.*;
import com.ftn.sbnz.model.dtos.RatingDTO;
import com.ftn.sbnz.model.dtos.SongDTO;
import com.ftn.sbnz.service.exceptions.NotFoundException;
import com.ftn.sbnz.service.repositories.EventRepository;
import com.ftn.sbnz.service.repositories.RatingRepository;
import com.ftn.sbnz.service.repositories.RecommendationRepository;
import com.ftn.sbnz.service.repositories.SongRepository;
import com.ftn.sbnz.service.services.RegularUserService;
import com.ftn.sbnz.service.services.SongService;
import com.ftn.sbnz.service.services.UserPreferenceService;
import com.ftn.sbnz.service.services.UserService;
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

    private final UserService userService;

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
    public boolean isFavoriteSong(Song song, User user) {
        UserPreference userPreference = userPreferenceService.findByUserId(user.getId());
        List<Song> favoriteSongs = userPreference.getFavoriteSongs();
        favoriteSongs.remove(song);

        for (Song favoriteSong : favoriteSongs) {
            if (favoriteSong.getId().equals(song.getId())) {
//                throw new BadRequestException(String.format("Song %s by %s is already in your favorites!", song.getName(), song.getArtist().getUsername()));
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isRatedSong(Song song, User user) {
        UserPreference userPreference = userPreferenceService.findByUserId(user.getId());
        List<Song> ratedSongs = userPreference.getRatedSongs();
        ratedSongs.remove(song);

        for (Song ratedSong : ratedSongs) {
            System.out.println(ratedSong.getName());
            if (ratedSong.getId().equals(song.getId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Song> getListenedSongsByUserIdAndGenre(Long userId, Long genreId){
        UserPreference userPreference = userPreferenceService.findByUserId(userId);
        List<Song> songsByGenre = new ArrayList<>();
        for(Song listenedSong: userPreference.getListenedSongs()){
            if(listenedSong.getGenre().getId().equals(genreId)){
                songsByGenre.add(listenedSong);
            }
        }
        return songsByGenre;
    }

    @Override
    public int getListenedSongsSizeByUserIdAndGenreId(Long userId, Long genreId) {
        UserPreference userPreference = userPreferenceService.findByUserId(userId);
        List<Song> songsByGenre = new ArrayList<>();
        for(Song listenedSong: userPreference.getListenedSongs()){
            if(listenedSong.getGenre().getId().equals(genreId)){
                songsByGenre.add(listenedSong);
            }
        }
        return songsByGenre.size();
    }

    @Override
    public List<Song> removeListenedSongs(List<Song> songs, Long userId, Long genreId) {
        List<Song> listenedSongs = getListenedSongsByUserIdAndGenre(userId, genreId);

        for(Song listenedSong : listenedSongs) {
            if (songs.contains(listenedSong)) {
                songs.remove(listenedSong);
            }
        }

        return songs;
    }

    @Override
    public Set<RecommendationDTO> addToFavoriteSongs(Long userId, Long songId) {
        Song song = findById(songId);
        User user = userService.findById(userId);
        UserPreference userPreference = this.userPreferenceService.findByUserId(user.getId());
        List<Song> favoriteSongs = userPreference.getFavoriteSongs();
        favoriteSongs.add(song);
        userPreferenceService.save(userPreference);

        Set<Recommendation> recommendations = new HashSet<>();

        KieSession kieSession = kieContainer.newKieSession("fwKsession");
        kieSession.setGlobal("songService", this);
        kieSession.setGlobal("genreId", song.getGenre().getId());
        kieSession.setGlobal("userId", user.getId());
        kieSession.setGlobal("songId", song.getId());
        kieSession.setGlobal("recommendations", recommendations);
        kieSession.setGlobal("firstRuleExecuted", Boolean.FALSE);
        kieSession.setGlobal("secondRuleExecuted", Boolean.FALSE);

        kieSession.insert(song);
        kieSession.insert("favorized");
        kieSession.insert(user);
        kieSession.fireAllRules();
        kieSession.dispose();

        Set<RecommendationDTO> recommendationDTOS = new HashSet<>();
        RegularUser regularUser = regularUserService.findRegularUserById(userId);
        for (Recommendation r : recommendations) {
            r.setUser(regularUser);
            recommendationRepository.save(r);
            recommendationDTOS.add(RecommendationDTO.toRecommendationDTO(r));
        }

        return recommendationDTOS;
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
    public List<Song> findAllByGenreWithoutDTO(Long genreId) {
        return songRepository.findAllByGenreId(genreId);
    }

    @Override
    public List<Song> removeAlreadyListenedSongs(List<Song> songs, Long userId) {
        UserPreference userPreference = this.userPreferenceService.findByUserId(userId);
        List<Song> listenedSongs = userPreference.getListenedSongs();

        for(Song song: songs){
            for(Song listenedSong: listenedSongs){
                if(song.getId().equals(listenedSong.getId())){
                   songs.remove(song);
                }
            }
        }

        return songs;
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
        User simpleUser = userService.findById(ratingDTO.getRatedById());
        System.out.println("REGULAR USER ID" + user.getId());
        UserPreference userPreference = user.getPreference();
        Song ratedSong = findById(ratingDTO.getSongId());
        System.out.println("SONG ID" + ratedSong.getId());
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

        KieSession newKieSession = kieContainer.newKieSession("fwKsession");
        newKieSession.setGlobal("songService", this);
        newKieSession.setGlobal("genreId", ratedSong.getGenre().getId());
        newKieSession.setGlobal("userId", user.getId());
        newKieSession.setGlobal("songId", ratedSong.getId());
        newKieSession.setGlobal("recommendations", recommendations);
        newKieSession.setGlobal("firstRuleExecuted", Boolean.FALSE);
        newKieSession.setGlobal("secondRuleExecuted", Boolean.FALSE);

        newKieSession.insert(ratedSong);
        newKieSession.insert("rated");
        newKieSession.insert(simpleUser);
        newKieSession.fireAllRules();
        newKieSession.dispose();
        

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
