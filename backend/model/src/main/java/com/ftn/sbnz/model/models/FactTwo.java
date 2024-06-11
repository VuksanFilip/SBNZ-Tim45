package com.ftn.sbnz.model.models;

import java.util.List;

public class FactTwo {

    private List<Song> songs;

    public FactTwo(List<Song> songs) {
        this.songs = songs;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
