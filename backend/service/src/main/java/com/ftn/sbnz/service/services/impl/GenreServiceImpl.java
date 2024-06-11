package com.ftn.sbnz.service.services.impl;

import com.ftn.sbnz.model.dtos.GenreDTO;
import com.ftn.sbnz.model.models.Artist;
import com.ftn.sbnz.model.models.Genre;
import com.ftn.sbnz.service.repositories.GenreRepository;
import com.ftn.sbnz.service.services.ArtistService;
import com.ftn.sbnz.service.services.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    private final ArtistService artistService;

    @Override
    public List<Genre> findAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Genre findGenreByName(String name) {
        return genreRepository.findByGenre(name).orElse(null);
    }

    @Override
    public void setArtistGenre(Long id, GenreDTO genre) {
        Artist artist = artistService.findArtistById(id);
        Genre foundGenre = findGenreByName(genre.getGenre());
        if (foundGenre == null) {
            Genre newGenre = Genre.builder()
                    .genre(genre.getGenre())
                    .build();
            Genre savedGenre = save(newGenre);
            artist.setGenre(savedGenre);
        }
        artist.setGenre(foundGenre);
    }

    @Override
    public Genre save(Genre genre) {
        return genreRepository.save(genre);
    }


}
