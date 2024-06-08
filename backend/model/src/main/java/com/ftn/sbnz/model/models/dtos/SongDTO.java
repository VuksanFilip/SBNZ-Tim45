package com.ftn.sbnz.model.models.dtos;

import com.ftn.sbnz.model.models.Song;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SongDTO {

    private String name;

    private String artist;

    private String album;

    private String genre;

    private int listensCount;

    private int favoritesCount;

    public static SongDTO toSongDTO(Song song) {
        return SongDTO.builder()
                .name(song.getName())
                .artist(song.getArtist().getUsername())
                .album(song.getAlbum().getTitle())
                .genre(song.getGenre().getGenre())
                .listensCount(song.getListensCount())
                .favoritesCount(song.getFavoritesCount())
                .build();
    }

}
