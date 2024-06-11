package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.dtos.RecommendationDTO;
import com.ftn.sbnz.model.models.*;
import com.ftn.sbnz.model.dtos.RatingDTO;
import com.ftn.sbnz.model.dtos.SongDTO;

import java.util.List;
import java.util.Set;

public interface SongService {

    Song findById(Long id);

    Set<SongDTO> addToFavoriteSongs(Long userId, Long songId);

    Set<SongDTO> addToListenedSongs(Long userId, Long songId);

    List<SongDTO> findAll();

    List<SongDTO> findAllByArtist(Long artistId);

    List<SongDTO> findAllByGenre(Long genreId);

    List<Song> findAllSongs();

    Recommendation recommendSongsByGenre(int number, Genre genre, RegularUser user, String explanation);

    Recommendation recommendSongsByArtist(int number, Artist artist, RegularUser user, String explanation);

    List<RecommendationDTO> listenToSong(Long userId, Long songId);

    List<RecommendationDTO> addRating(RatingDTO ratingDTO);

    List<RecommendationDTO> findNewMusic(Long userId);

    Recommendation recommendPopularSong(Song song);

    List<Song> getAllSongs();

    List<SongDTO> getUsersFavoriteSongs(Long userId);
}
