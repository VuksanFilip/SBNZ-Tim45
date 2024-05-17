package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.models.Song;

public interface SongService {

    Song findById(Long id);

    String addToFavoriteSongs(Long userId, Long songId);

    String addToListenedSongs(Long userId, Long songId);

}
