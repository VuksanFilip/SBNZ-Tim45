package com.ftn.sbnz.model.models;

import com.ftn.sbnz.model.models.enums.Genre;

import java.time.LocalDateTime;
import java.util.List;

public class Album {
    private Long id;
    private Artist artist;
    private String title;
    private List<Song> songs;
    private LocalDateTime releaseDate;
    private Genre genre;
}
