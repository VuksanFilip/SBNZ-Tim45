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
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @ManyToMany
    @JoinTable(
            name = "listened_songs",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id"))
    private List<Song> listenedSongs;

    @ManyToMany
    @JoinTable(
            name = "rated_songs",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id"))
    private List<Song> ratedSongs;

    @ManyToMany
    @JoinTable(
            name = "favorite_songs",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id"))
    private List<Song> favoriteSongs;


    @OneToOne(mappedBy = "user")
    private UserPreference preference;

    @OneToMany(mappedBy = "ratedBy", cascade = CascadeType.ALL)
    private List<Rating> ratings;

}
