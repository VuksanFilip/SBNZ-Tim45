package com.ftn.sbnz.model.models;

import com.ftn.sbnz.model.models.enums.Genre;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Album {
    @Id
    private Long id;
    @OneToOne
    private Artist artist;
    private String title;
    @OneToMany
    private List<Song> songs;
    private LocalDateTime releaseDate;
    private Genre genre;
}
