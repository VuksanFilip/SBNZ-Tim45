package com.ftn.sbnz.model.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RatingDTO {

    private Long ratedById;

    private Long songId;

    private int rating;

    private String comment;

}
