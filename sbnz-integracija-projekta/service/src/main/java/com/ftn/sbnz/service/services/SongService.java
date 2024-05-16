package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.models.Song;
import com.ftn.sbnz.service.dtos.RatingDTO;

public interface SongService {

    Song findById(Long id);

    String addToFavoriteSongs(Long userId, Long songId);

    String addToListenedSongs(Long userId, Long songId);

}
