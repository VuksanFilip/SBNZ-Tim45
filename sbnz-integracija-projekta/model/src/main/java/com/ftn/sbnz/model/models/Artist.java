package com.ftn.sbnz.model.models;

import com.ftn.sbnz.model.models.enums.Genre;

import java.util.List;

public class Artist {

    private Long id;
    private String username;
    private String password;
    private Genre genre;
    private List<Album> albums;
    private List<Song> songs;
}
