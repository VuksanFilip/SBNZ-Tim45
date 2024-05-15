package com.ftn.sbnz.model.models;

import java.util.List;

//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//
//@NoArgsConstructor
//@Setter
//@Getter
//@ToString
//@Entity
public class User {
//    @Id
    private Long id;
    private String username;
    private String password;
    private List<Song> listenedSongs;
    private List<Song> ratedSongs;
    private List<Song> favoriteSongs;
    private UserPreference preference;
//    private List<Recommodation> pastRecommodations;

}

