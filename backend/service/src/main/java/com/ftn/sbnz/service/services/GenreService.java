package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.dtos.GenreDTO;
import com.ftn.sbnz.model.models.Genre;

import java.util.List;

public interface GenreService {

    List<Genre> findAllGenres();

    void basicBackward();

    void findArtistGenre();

    void findAlbumGenre();

    void findSimilarArtists();

    Genre findGenreByName(String name);

    void setArtistGenre(Long id, GenreDTO genre);

    Genre save(Genre genre);

}
