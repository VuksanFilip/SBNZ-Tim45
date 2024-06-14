package com.ftn.sbnz.model.dtos;

import com.ftn.sbnz.model.models.Song;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SongDTO {

    private Long id;

    private String name;

    private String artist;

    private String album;

    private String genre;

    private int listensCount;

    private int favoritesCount;

    private String length;

    public static SongDTO toSongDTO(Song song) {
        String albumTitle = "";
        if (song.getAlbum() != null) {
            albumTitle = song.getAlbum().getTitle();
        }
        return SongDTO.builder()
                .id(song.getId())
                .name(song.getName())
                .artist(song.getArtist().getUsername())
                .album(albumTitle)
                .genre(song.getGenre().getGenre())
                .listensCount(song.getListensCount())
                .favoritesCount(song.getFavoritesCount())
                .length(song.getLength())
                .build();
    }

}
