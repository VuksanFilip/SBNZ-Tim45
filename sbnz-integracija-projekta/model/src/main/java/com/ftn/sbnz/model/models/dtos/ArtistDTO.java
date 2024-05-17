package com.ftn.sbnz.model.models.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArtistDTO {

    private String username;

    private GenreDTO genre;

    private List<AlbumDTO> albums;

    private List<SongDTO> songs;

}
