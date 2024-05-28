package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.models.Artist;
import com.ftn.sbnz.model.models.User;
import com.ftn.sbnz.model.models.dtos.ArtistDTO;

import java.util.List;

public interface ArtistService {
    List<ArtistDTO> findAll();

    ArtistDTO findBySong(Long songId);

    ArtistDTO findByGenre(Long genreId);

    List<Artist> findAllArtists();
}
