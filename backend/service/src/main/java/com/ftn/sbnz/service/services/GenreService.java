package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.dtos.GenreDTO;
import com.ftn.sbnz.model.models.Genre;

import java.util.List;
import java.util.Set;

public interface GenreService {

    List<Genre> findAllGenres();

    Genre findGenreByName(String name);

    void setArtistGenre(Long id, GenreDTO genre);

    Genre save(Genre genre);

}
