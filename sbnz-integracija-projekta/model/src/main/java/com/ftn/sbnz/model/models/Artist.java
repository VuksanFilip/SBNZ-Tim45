package com.ftn.sbnz.model.models;

import com.ftn.sbnz.model.models.enums.Genre;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Artist {
    @Id
    private Long id;
    private String username;
    private String password;
    private Genre genre;
    @OneToMany
    private List<Album> albums;
    @OneToMany
    private List<Song> songs;
}
