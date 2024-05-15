package com.ftn.sbnz.model.models;

import com.ftn.sbnz.model.models.enums.Genre;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    private Artist artist;
    @OneToOne
    private Album album;
    private Genre genre;
    private LocalDateTime releaseDate;
    @OneToMany
    private List<Rating> ratings;
    private int favoritesCount;
    private int listensCount;
}
