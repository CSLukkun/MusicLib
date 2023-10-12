package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;


/**
 * Represents an album with information such as name, type, artist, and a list of tracks.
 */
public class Album implements Identifier {

    private String albumId;
    private String name;
    protected AlbumType type;
    private Artist artist;
    protected List<MusicTrack> tracks;

    /**
     * Constructs an album with the given name, type, and artist.
     *
     */
    public Album(String name) {
        this.albumId = generateUniqueId();
        this.name = name;
        this.type = AlbumType.COMMON_ALBUM;
        this.artist = null;
        this.tracks = new ArrayList<>();
    }

    public String getAlbumId() {
        return albumId;
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
     * Gets the overall time of the album in Seconds.
     *
     * @return The total time of the album.
     */
    public int getTotalTimeOfTracks() {
        int totalTimeOfTracks = 0;

        for (MusicTrack track : tracks) {
            totalTimeOfTracks += track.getLengthInSeconds();
        }

        return totalTimeOfTracks;
    }

    /**
     * Gets the overall file size of the album in bytes.
     *
     * @return The total file size of the album.
     */
    public long getTotalFileSize() {
        long totalFileSize = 0;
        for (MusicTrack track : tracks) {
            totalFileSize += track.getFileSizeInBytes();
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
            return 0.0;
        }

        double totalRating = 0.0;
        for (MusicTrack track : tracks) {
            totalRating += track.getRating();
        }

        return totalRating / tracks.size();
    }

    public void sortTracksByName() {
        Collections.sort(tracks);
    }

    @Override
    public String toString() {
        return "Album: " + name + ", Type: " + type + ", Artist: " + artist.getName();
    }

    @Override
    public String generateUniqueId() {
        String timestamp = Long.toString(System.currentTimeMillis());
        String randomUUID = UUID.randomUUID().toString();

        return "album-" + timestamp + "-" + randomUUID;
    }
}
