package com.ftn.sbnz.model.models.dtos;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlbumDTO {

    private String title;

    private LocalDateTime releaseDate;

    private GenreDTO genre;

    private ArtistDTO artistDTO;

    private List<SongDTO> songs;

}
