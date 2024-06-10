package com.ftn.sbnz.model.models;

public class UserMood {

    private String currentMood;

    public UserMood() {
    }

    public UserMood(String currentMood) {
        this.currentMood = currentMood;
    }

    public String getCurrentMood() {
        return currentMood;
    }

    public void setCurrentMood(String currentMood) {
        this.currentMood = currentMood;
    }

}
