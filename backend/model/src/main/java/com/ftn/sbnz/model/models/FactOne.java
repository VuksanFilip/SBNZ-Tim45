package com.ftn.sbnz.model.models;

import java.util.List;

public class FactOne {
    private List<Song> songs;

    public FactOne(List<Song> songs) {
        this.songs = songs;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
