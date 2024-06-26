package com.ftn.sbnz.service.services.impl;

import com.ftn.sbnz.model.models.Album;
import com.ftn.sbnz.model.dtos.AlbumDTO;
import com.ftn.sbnz.service.exceptions.NotFoundException;
import com.ftn.sbnz.service.repositories.AlbumRepository;
import com.ftn.sbnz.service.services.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;

    @Override
    public AlbumDTO findBySong(Long songId) {
        Album album = albumRepository.findBySongId(songId)
                .orElseThrow(() -> new NotFoundException(String.format("Album with song id %s not found!", songId)));
        return AlbumDTO.toAlbumDTO(album);
    }

    @Override
    public AlbumDTO findByArtist(Long artistId) {
        Album album = albumRepository.findByArtistId(artistId)
                .orElseThrow(() -> new NotFoundException(String.format("Album with artist id %s not found!", artistId)));
        return AlbumDTO.toAlbumDTO(album);
    }

    @Override
    public List<Album> findAllAlbums() {
        return albumRepository.findAll();
    }

    @Override
    public List<AlbumDTO> findAllAlbumDTOs() {
        return findAllAlbums().stream().map(AlbumDTO::toAlbumDTO).collect(Collectors.toList());
    }

    @Override
    public Album findById(Long id) {
        return albumRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("No album with id %s", id)));
    }
}
