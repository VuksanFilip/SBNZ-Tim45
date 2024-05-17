package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.models.dtos.AlbumDTO;

public interface AlbumService {
    AlbumDTO findBySong(Long songId);

    AlbumDTO findByArtist(Long artistId);
}
