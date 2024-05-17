package com.ftn.sbnz.model.models.dtos;

import com.ftn.sbnz.model.models.Artist;
import com.ftn.sbnz.model.models.Song;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArtistDTO {

    private String username;

    private String genre;

    public static ArtistDTO toArtistDTO(Artist artist) {
        return ArtistDTO.builder()
                .username(artist.getUsername())
                .genre(artist.getGenre().getGenre())
                .build();
    }

}
