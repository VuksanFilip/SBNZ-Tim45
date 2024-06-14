package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.dtos.GenreDTO;
import com.ftn.sbnz.model.dtos.UserDTO;
import com.ftn.sbnz.model.models.Artist;
import com.ftn.sbnz.model.dtos.ArtistDTO;

import java.util.List;

public interface ArtistService {

    List<ArtistDTO> findAll();

    ArtistDTO findBySong(Long songId);

    ArtistDTO findByGenre(Long genreId);

    List<Artist> findAllArtists();

    Artist findArtistById(Long id);

    UserDTO getArtist(Long id);

    GenreDTO getArtistGenre(Long id);

}
