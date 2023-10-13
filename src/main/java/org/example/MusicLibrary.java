package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Represents a music library that stores tracks and albums.
 */
public class MusicLibrary implements Identifier {
    private String libId;

    private String name;
    private HashMap<String,MusicTrack> tracks;
    private HashMap<String,Album> albums;

    /**
     * Constructs a music library with empty lists of tracks and albums.
     */
    public MusicLibrary(String name) {
        this.name = name;
        this.libId = generateUniqueId();
        this.tracks = new HashMap<>();
        this.albums = new HashMap<>();
    }

    /**
     * Adds a music track to the library.
     *
     * @param track The track to be added.
     */
    public void addTrack(MusicTrack track) {
        tracks.put(track.getTrackId(), track);
    }

    /**
     * Adds an album to the library.
     *
     * @param album The album to be added.
     */
    public void addAlbum(Album album) {
        albums.put(album.getAlbumId(), album);
    }

    /**
     * Creates and returns a list of tracks with the lowest rating in the library.
     *
     * @return A list of tracks with the lowest rating.
     */
    public ArrayList<MusicTrack> getTracksWithLowestRating() {
        if (tracks.isEmpty()) {
            return new ArrayList<>();
        }

        int lowestRating = Integer.MAX_VALUE;
        ArrayList<MusicTrack> lowestRatedTracks = new ArrayList<>();

        for (MusicTrack track : tracks.values()) {
            if (track.getRating() < lowestRating) {
                lowestRating = track.getRating();
                lowestRatedTracks.clear();
                lowestRatedTracks.add(track);
            } else if (track.getRating() == lowestRating) {
                lowestRatedTracks.add(track);
            }
        }

        return lowestRatedTracks;
    }

    @Override
    public String generateUniqueId() {
        String timestamp = Long.toString(System.currentTimeMillis());
        String randomUUID = UUID.randomUUID().toString();

        return "lib-" + timestamp + "-" + randomUUID;
    }

    @Override
    public String toString() {
        StringBuilder libraryInfo = new StringBuilder("Library: " + name + "\n" + "Tracks: " + "\n" + tracks + "\n" + "Albums: " + "\n" + albums);
        return libraryInfo.toString();
    }
}
