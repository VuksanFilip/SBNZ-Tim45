package com.ftn.sbnz.model.models;

import java.util.List;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @OneToMany
    private List<Song> listenedSongs;
    @OneToMany
    private List<Song> ratedSongs;
    @OneToMany
    private List<Song> favoriteSongs;
    @OneToOne
    private UserPreference preference;
//    private List<Recommodation> pastRecommodations;

}

