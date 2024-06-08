package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.models.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> findAllGenres();

    void basicBackward();

    void findArtistGenre();

    void findAlbumGenre();

    void findSimilarArtists();
}
