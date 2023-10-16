package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent a disc with its fixed capacity.
 */
public class Disc {
    /**
     * The size of the disc holding
     */
    private int capacity;

    /**
     * The size of the disc has used
     */
    private int usedSpace = 0;

    /**
     * The tracks in the disc.
     */
    private List<MusicTrack> tracksOnDisc = new ArrayList<>();

    /**
     * Constructor of Class Disc with a integer capacity
     * @param capacity
     */
    public Disc(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Determine if the current disc can fit a new track
     *
     * @param track The tracked would be added in the track.
     * @return True. The tracked can be added in the track. False. The tracked can not added in the track.
     */
    public boolean canFit(MusicTrack track) {
        return usedSpace + track.getFileSizeInBytes() <= capacity;
    }


    /**
     * Adds a track into the disc
     * @param track The track to be added
     */
    public void addTrack(MusicTrack track) {
        if (canFit(track)) {
            tracksOnDisc.add(track);
            usedSpace += track.getFileSizeInBytes();
        }
    }

    /**
     * Return a formatted string to show the content of the disc.
     * Showing a list including all tracks in the disc.
     *
     * @return The formatted string
     */
    @Override
    public String toString() {
        return "\nThis disc includes the following tracks: " + tracksOnDisc +
                "\n-----------------------------------------------------------";
    }
}