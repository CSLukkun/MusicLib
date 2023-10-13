package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;


/**
 * Represents an album with information such as name, type, artist, and a list of tracks.
 */
public class Album implements Identifier {

    protected String albumId;
    protected String name;
    protected AlbumType type;
    private Artist artist;
    protected ArrayList<String> tracks;

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Artist getArtist() {
        return artist;
    }

    /**
     * Constructs an album with the given name, type, and artist.
     *
     */
    public Album(String name) {
        this.albumId = generateUniqueId();
        this.artist = new Artist("There is no artist");
        this.name = name;
        this.type = AlbumType.COMMON_ALBUM;
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
        tracks.add(track.getTrackId());
        track.setOriginalAlbum(this);
        artist = track.getArtist();
    }

    public void removeTrack(MusicTrack track) {
        tracks.remove(track);
    }

    /**
     * Gets the overall time of the album in Seconds.
     *
     * @return The total time of the album.
     */
    public int getTotalTimeOfTracks(ArrayList<MusicTrack> tracks) {
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
    public long getTotalFileSize(ArrayList<MusicTrack> tracks) {
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
    public double getAverageRating(ArrayList<MusicTrack> tracks) {
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
        return "AlbumName: " + name+ "\n" + "Tracks: " + "\n" + tracks;
    }

    @Override
    public String generateUniqueId() {
        String timestamp = Long.toString(System.currentTimeMillis());
        String randomUUID = UUID.randomUUID().toString();

        return "album-" + timestamp + "-" + randomUUID;
    }

    public ArrayList<String> getTracks() {
        return tracks;
    }
}
