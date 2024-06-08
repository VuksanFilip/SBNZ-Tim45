package com.ftn.sbnz.model.models.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPreferenceDTO {

    private List<SongDTO> favoritedSongs;

    private List<SongDTO> listenedSongs;

    private List<SongDTO> ratedSongs;

    private List<SongDTO> explicitSongs;

    private List<ArtistDTO> explicitArtists;

    private List<GenreDTO> explicitGenres;

}
