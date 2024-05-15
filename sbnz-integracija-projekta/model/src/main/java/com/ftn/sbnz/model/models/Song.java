package com.ftn.sbnz.model.models;

import com.ftn.sbnz.model.models.enums.Genre;

import java.time.LocalDateTime;
import java.util.List;

public class Song {
    private Long id;
    private String name;
    private Artist artist;
    private Album album;
    private Genre genre;
    private LocalDateTime releaseDate;
    private List<Rating> ratings;
    private int favoritesCount;
    private int listensCount;
}
