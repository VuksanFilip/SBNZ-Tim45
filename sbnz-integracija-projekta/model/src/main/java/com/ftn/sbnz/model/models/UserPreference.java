package com.ftn.sbnz.model.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_preferences")
public class UserPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "listened_songs",
            joinColumns = @JoinColumn(name = "user_preference_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id"))
    private List<Song> listenedSongs;

    @ManyToMany
    @JoinTable(
            name = "rated_songs",
            joinColumns = @JoinColumn(name = "user_preference_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id"))
    private List<Song> ratedSongs;

    @ManyToMany
    @JoinTable(
            name = "favorite_songs",
            joinColumns = @JoinColumn(name = "user_preference_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id"))
    private List<Song> favoriteSongs;

    @ManyToMany
    @JoinTable(
            name = "explicit_songs",
            joinColumns = @JoinColumn(name = "user_preference_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id"))
    private List<Song> explicitSongs;


    @ManyToMany
    @JoinTable(
            name = "explicit_artists",
            joinColumns = @JoinColumn(name = "user_preference_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id"))
    private List<Artist> explicitArtists;

    @ManyToMany
    @JoinTable(
            name = "explicit_genres",
            joinColumns = @JoinColumn(name = "user_preference_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> explicitGenres;

}
