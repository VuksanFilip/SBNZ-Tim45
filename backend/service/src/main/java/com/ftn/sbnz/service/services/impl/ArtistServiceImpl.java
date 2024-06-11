package com.ftn.sbnz.service.services.impl;

import com.ftn.sbnz.model.dtos.GenreDTO;
import com.ftn.sbnz.model.dtos.UserDTO;
import com.ftn.sbnz.model.models.Artist;
import com.ftn.sbnz.model.dtos.ArtistDTO;
import com.ftn.sbnz.model.models.Genre;
import com.ftn.sbnz.service.exceptions.NotFoundException;
import com.ftn.sbnz.service.repositories.ArtistRepository;
import com.ftn.sbnz.service.services.ArtistService;
import com.ftn.sbnz.service.services.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    @Override
    public List<ArtistDTO> findAll() {
        return artistRepository.findAll().stream()
                .map(ArtistDTO::toArtistDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ArtistDTO findBySong(Long songId) {
        Artist artist = artistRepository.findBySongId(songId)
                .orElseThrow(() -> new NotFoundException(String.format("Artis with song id %s not found!", songId)));
        return ArtistDTO.toArtistDTO(artist);
    }

    @Override
    public ArtistDTO findByGenre(Long genreId) {
        Artist artist = artistRepository.findByGenre_Id(genreId)
                .orElseThrow(() -> new NotFoundException(String.format("Artis with genre id %s not found!", genreId)));
        return ArtistDTO.toArtistDTO(artist);
    }

    @Override
    public List<Artist> findAllArtists() {
        return artistRepository.findAll();
    }

    @Override
    public Artist findArtistById(Long id) {
        return artistRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("No artist with id %s.", id)));
    }

    @Override
    public UserDTO getArtist(Long id) {
        return UserDTO.toUserDTO(findArtistById(id));
    }

    @Override
    public GenreDTO getArtistGenre(Long id) {
        Genre genre = findArtistById(id).getGenre();
        if (genre == null) {
            return GenreDTO.toGenreDTO("");
        }
        return GenreDTO.toGenreDTO(genre.getGenre());
    }

}
