package com.ftn.sbnz.model.dtos;

import com.ftn.sbnz.model.models.Song;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecommendedSongDTO {

    private String name;

    private String artist;

    private String genre;

    public static RecommendedSongDTO toRecommendedSongDTO(Song song) {
        return RecommendedSongDTO.builder()
                .name(song.getName())
                .artist(song.getArtist().getUsername())
                .genre(song.getGenre().getGenre())
                .build();
    }

}
