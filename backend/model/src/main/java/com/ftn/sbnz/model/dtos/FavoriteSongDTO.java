package com.ftn.sbnz.model.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FavoriteSongDTO {

    private Long ratedById;

    private Long songId;

    private int rating;

    private String comment;
}
