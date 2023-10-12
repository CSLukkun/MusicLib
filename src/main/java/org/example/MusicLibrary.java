package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a music library that stores tracks and albums.
 */
public class MusicLibrary {
    private List<MusicTrack> tracks;
    private List<Album> albums;

    /**
     * Constructs a music library with empty lists of tracks and albums.
     */
    public MusicLibrary() {
        this.tracks = new ArrayList<>();
        this.albums = new ArrayList<>();
    }

    /**
     * Adds a music track to the library.
     *
     * @param track The track to be added.
     */
    public void addTrack(MusicTrack track) {
        tracks.add(track);
    }

    /**
     * Adds an album to the library.
     *
     * @param album The album to be added.
     */
    public void addAlbum(Album album) {
        albums.add(album);
    }

    /**
     * Creates and returns a list of tracks with the lowest rating in the library.
     *
     * @return A list of tracks with the lowest rating.
     */
    public List<MusicTrack> getTracksWithLowestRating() {
        if (tracks.isEmpty()) {
            return new ArrayList<>();
        }

        int lowestRating = Integer.MAX_VALUE;
        List<MusicTrack> lowestRatedTracks = new ArrayList<>();

        for (MusicTrack track : tracks) {
            int trackRating = track.getRating();
            if (trackRating < lowestRating) {
                lowestRating = trackRating;
                lowestRatedTracks.clear();
                lowestRatedTracks.add(track);
            } else if (trackRating == lowestRating) {
                lowestRatedTracks.add(track);
            }
        }

        return lowestRatedTracks;
    }
}
