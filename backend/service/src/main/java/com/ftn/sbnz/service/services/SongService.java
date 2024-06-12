package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.dtos.FavoriteSongDTO;
import com.ftn.sbnz.model.dtos.RecommendationDTO;
import com.ftn.sbnz.model.models.*;
import com.ftn.sbnz.model.dtos.RatingDTO;
import com.ftn.sbnz.model.dtos.SongDTO;

import java.util.List;
import java.util.Set;

public interface SongService {

    Song findById(Long id);

    boolean isFavoriteSong(Song song, User user);

    boolean isRatedSong(Song song, User user);

    List<Song> getListenedSongsByUserIdAndGenre(Long userId, Long genreId);

    int getListenedSongsSizeByUserIdAndGenreId(Long userId, Long genreId);

    List<Song> removeListenedSongs(List<Song> songs, Long userId, Long genreId);

    Set<SongDTO> addToFavoriteSongs(FavoriteSongDTO favoriteSongDTO);

    Set<SongDTO> addToListenedSongs(Long userId, Long songId);

    List<SongDTO> findAll();

    List<SongDTO> findAllByArtist(Long artistId);

    List<Song> findAllByGenreWithoutDTO(Long genreId);

    List<Song> removeAlreadyListenedSongs(List<Song> songs, Long userId);

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
