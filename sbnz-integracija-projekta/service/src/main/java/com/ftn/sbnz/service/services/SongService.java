package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.models.*;
import com.ftn.sbnz.model.models.dtos.RatingDTO;
import com.ftn.sbnz.model.models.dtos.SongDTO;

import java.util.List;
import java.util.Set;

public interface SongService {

    Song findById(Long id);

    Set<SongDTO> addToFavoriteSongs(Long userId, Long songId);

    Set<SongDTO> addToListenedSongs(Long userId, Long songId);

    List<SongDTO> findAll();

    List<SongDTO> findAllByArtist(Long artistId);

    List<SongDTO> findAllByGenre(Long genreId);

    Set<SongDTO> rateSong(RatingDTO ratingDTO);

    List<Song> findAllSongs();

    Recommendation recommendSongsByGenre(int number, Genre genre, User user, String explanation);

    Recommendation recommendSongsByArtist(int number, Artist artist, User user, String explanation);

    void listenToSong(Long userId, Long songId);

    void addRating(RatingDTO ratingDTO);

    Set<Recommendation> findNewMusic(Long userId);

    Recommendation recommendPopularSong(Song song);

}
