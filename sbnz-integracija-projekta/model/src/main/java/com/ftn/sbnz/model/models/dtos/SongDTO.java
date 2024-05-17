package com.ftn.sbnz.model.models.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SongDTO {

    private String name;

    private ArtistDTO artist;

    private AlbumDTO album;

    private GenreDTO genre;

    private List<RatingDTO> ratings;

    private int listensCount;

    private int favoritesCount;


}
