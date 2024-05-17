package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.models.Song;
import com.ftn.sbnz.model.models.dtos.SongDTO;

import java.util.List;

public interface SongService {

    Song findById(Long id);

    List<SongDTO> findAll();

    List<SongDTO> findAllByArtist(Long artistId);

    List<SongDTO> findAllByGenre(Long genreId);

//    String addToFavoriteSongs(Long userId, Long songId);
//
//    String addToListenedSongs(Long userId, Long songId);

}
