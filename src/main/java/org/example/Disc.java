package org.example;

import java.util.ArrayList;
import java.util.List;

public class Disc {
    private int capacity;
    private int usedSpace = 0;
    private List<MusicTrack> tracksOnDisc = new ArrayList<>();

    public Disc(int capacity) {
        this.capacity = capacity;
    }

    public boolean canFit(MusicTrack track) {
        return usedSpace + track.getFileSizeInBytes() <= capacity;
    }

    public void addTrack(MusicTrack track) {
        if (canFit(track)) {
            tracksOnDisc.add(track);
            usedSpace += track.getFileSizeInBytes();
        }
    }

    @Override
    public String toString() {
        return "\nThis disc includes the following tracks: " + tracksOnDisc +
                "\n-----------------------------------------------------------";
    }
}