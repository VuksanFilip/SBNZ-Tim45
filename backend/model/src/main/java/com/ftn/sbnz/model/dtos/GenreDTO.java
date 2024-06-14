package com.ftn.sbnz.model.dtos;

import com.ftn.sbnz.model.models.Genre;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenreDTO {

    private String genre;

    public static GenreDTO toGenreDTO(String genre) {
        return GenreDTO.builder()
                .genre(genre)
                .build();
    }

}
