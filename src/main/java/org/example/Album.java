package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an album with information such as name, type, artist, and a list of tracks.
 */
public class Album {
    private String name;
    private String type;
    private Artist artist;
    private List<MusicTrack> tracks;

    /**
     * Constructs an album with the given name, type, and artist.
     *
     * @param name   The name of the album.
     * @param type   The type or genre of the album.
     * @param artist The artist who released the album.
     */
    public Album(String name, String type, Artist artist) {
        this.name = name;
        this.type = type;
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }

    /**
     * Adds a music track to the album.
     *
     * @param track The track to be added.
     */
    public void addTrack(MusicTrack track) {
        tracks.add(track);
    }

    public void removeTrack(MusicTrack track) {
        tracks.remove(track);
    }

    /**
     * Gets the overall running time of the album in minutes.
     *
     * @return The total running time of the album.
     */
    public double getOverallRunningTime() {
        double totalRunningTime = 0.0;
        for (MusicTrack track : tracks) {
            totalRunningTime += track.getPlayingTime();
        }
        return totalRunningTime;
    }

    /**
     * Gets the overall file size of the album in bytes.
     *
     * @return The total file size of the album.
     */
    public long getOverallFileSize() {
        long totalFileSize = 0;
        for (MusicTrack track : tracks) {
            totalFileSize += track.getSize();
        }
        return totalFileSize;
    }

    /**
     * Gets the average rating of tracks on the album.
     *
     * @return The average rating of the album's tracks.
     */
    public double getAverageRating() {
        if (tracks.isEmpty()) {
            return 0.0; // Avoid division by zero if there are no tracks.
        }

        double totalRating = 0.0;
        for (MusicTrack track : tracks) {
            totalRating += track.getRating();
        }

        return totalRating / tracks.size();
    }

    // Add getters and setters for name, type, artist, and tracks

    @Override
    public String toString() {
        return "Album: " + name + ", Type: " + type + ", Artist: " + artist.getName();
    }
}
