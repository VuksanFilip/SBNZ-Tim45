package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.models.Album;
import com.ftn.sbnz.model.dtos.AlbumDTO;

import java.util.List;

public interface AlbumService {

    AlbumDTO findBySong(Long songId);

    AlbumDTO findByArtist(Long artistId);

    List<Album> findAllAlbums();

    List<AlbumDTO> findAllAlbumDTOs();

    Album findById(Long id);
}
