package com.ftn.sbnz.model.models.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RatingDTO {

    private UserDTO ratedBy;

    private SongDTO song;

    private int rating;

    private String comment;

}
