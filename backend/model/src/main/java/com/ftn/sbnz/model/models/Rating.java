package com.ftn.sbnz.model.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rated_by")
    private RegularUser ratedBy;

    @ManyToOne
    @JoinColumn(name = "song_id")
    private Song song;

    @Column
    private int rating;

    @Column
    private String comment;

}
