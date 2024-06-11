package com.ftn.sbnz.model.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FavoriteSongDTO {

    private Long favorizedById;

    private Long songId;
}
