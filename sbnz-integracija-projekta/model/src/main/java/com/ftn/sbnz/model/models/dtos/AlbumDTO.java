package com.ftn.sbnz.model.models.dtos;

import com.ftn.sbnz.model.models.Album;
import com.ftn.sbnz.model.models.Artist;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlbumDTO {

    private String title;

    private LocalDateTime releaseDate;

    private String genre;

    private String artist;

    private List<SongDTO> songs;

    public static AlbumDTO toAlbumDTO(Album album) {
        return AlbumDTO.builder()
                .title(album.getTitle())
                .releaseDate(album.getReleaseDate())
                .genre(album.getGenre().getGenre())
                .artist(album.getArtist().getUsername())
                .songs(album.getSongs().stream().map(song -> SongDTO.toSongDTO(song)).collect(Collectors.toList()))
                .build();
    }

}
