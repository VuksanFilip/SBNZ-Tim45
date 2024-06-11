package com.ftn.sbnz.model.models;

import java.util.List;

public class ListenedSongsFact {
    private List<Song> listenedSongs;

    public ListenedSongsFact(List<Song> listenedSongs) {
        this.listenedSongs = listenedSongs;
    }

    public List<Song> getListenedSongs() {
        return listenedSongs;
    }

    public void setListenedSongs(List<Song> listenedSongs) {
        this.listenedSongs = listenedSongs;
    }
}