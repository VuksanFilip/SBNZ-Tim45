package com.ftn.sbnz.model.dtos;

import com.ftn.sbnz.model.models.Album;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlbumDTO {

    private Long id;

    private String title;

    private LocalDate releaseDate;

    private String genre;

    private String artist;

    private List<SongDTO> songs;

    public static AlbumDTO toAlbumDTO(Album album) {
        return AlbumDTO.builder()
                .id(album.getId())
                .title(album.getTitle())
                .releaseDate(album.getReleaseDate())
                .genre(album.getGenre().getGenre())
                .artist(album.getArtist().getUsername())
                .songs(album.getSongs().stream().map(SongDTO::toSongDTO).collect(Collectors.toList()))
                .build();
    }

}
