package com.example.firstpractical;

public class RecordingPlayer {

    private int id;
    private String name;
    private boolean isPlaying;

    public RecordingPlayer(int id, String name, boolean isPlaying) {
        this.id = id;
        this.name = name;
        this.isPlaying = isPlaying;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isPlaying() {
        return isPlaying;
    }
}
