package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.models.Song;
import com.ftn.sbnz.model.models.dtos.RatingDTO;
import com.ftn.sbnz.model.models.dtos.SongDTO;
import com.ftn.sbnz.service.dtos.RecommendedSongDTO;

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
}
