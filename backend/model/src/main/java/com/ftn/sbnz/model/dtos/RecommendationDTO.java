package com.ftn.sbnz.model.dtos;

import com.ftn.sbnz.model.models.Recommendation;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecommendationDTO {

    private String explanation;

    private List<RecommendedSongDTO> recommendedSongs;

    public static RecommendationDTO toRecommendationDTO(Recommendation recommendation) {
        return RecommendationDTO.builder()
                .explanation(recommendation.getExplanation())
                .recommendedSongs(recommendation.getSongs().stream()
                        .map(RecommendedSongDTO::toRecommendedSongDTO)
                        .collect(Collectors.toList()))
                .build();
    }

}
