package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Represents a music library that stores tracks and albums.
 * Each library is identified by a unique id, a name, and has storage for tracks and albums
 */
public class MusicLibrary implements Identifier {
    /**
     * The unique identifier in string formatted
     */
    private final String libId;

    /**
     * The name of the lib
     */
    private String name;

    /**
     * A map holding a collection of music tracks, where the key represents
     * the unique identifier or name of the track, and the value is the MusicTrack object itself.
     */
    private HashMap<String,MusicTrack> tracks;

    /**
     * A map holding a collection of music albums, where the key represents
     * the unique identifier or name of the track, and the value is the music album object itself.
     */
    private HashMap<String,Album> albums;

    /**
     * Constructs a music library with empty lists of tracks and albums.
     *
     * @param name the name of the library.
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
        albums.put(track.getOriginalAlbum().getAlbumId(), track.getOriginalAlbum());
    }

    /**
     * Removes a music track to the library.
     *
     * @param track The track to be removed.
     */
    public void removeTrack(MusicTrack track) {
        List<Album> albumList = new ArrayList<>(albums.values());
        for (Album album: albumList) {
            List<MusicTrack> toRemove = new ArrayList<>(album.getTracks());
            for (MusicTrack trackInCurrentAlbum : toRemove) {
                if (trackInCurrentAlbum.getTrackId().equals(track.getTrackId())) {
                    album.removeTrack(track);
                }
            }
        }

        tracks.remove(track.getTrackId());
    }

    /**
     * Adds an album to the library.
     * Adds all tracks in the album into the library
     *
     * @param album The album to be added.
     */
    public void addAlbum(Album album) {
        albums.put(album.getAlbumId(), album);
        album.getTracks().forEach(track -> this.addTrack(track));
    }

    /**
     * Removes an album in the library.
     * Removes all tracks of the album into the library
     *
     * @param album The album to be added.
     */
    public void removeAlbum(Album album) {
        albums.remove(album.getAlbumId());
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

    /**
     * Gets all tracks in the library.
     *
     * @return A list of all tracks
     */
    public List<MusicTrack> getAllTracks() {
        return new ArrayList<>(tracks.values());
    }

    /**
     * Get all albums in the library.
     *
     * @return A list of all library.
     */
    public List<Album> getAllAlbums() {
        return new ArrayList<>(albums.values());
    }


    /**
     * Generate a formatted string which includes a current timestamp and a randomUUID.
     *
     * @return the formatted string
     */
    @Override
    public String generateUniqueId() {
        String timestamp = Long.toString(System.currentTimeMillis());
        String randomUUID = UUID.randomUUID().toString();

        return "lib-" + timestamp + "-" + randomUUID;
    }

    /**
     * Return a formatted string including the lib's name, the lib's tracks, and the lib's albums.
     *
     * @return a formatted string.
     */
    @Override
    public String toString() {
        return "Library: " + name + "\n" + "Tracks: " + "\n" + tracks + "\n" + "Albums: " + "\n" + albums;
    }

    /**
     * Back up a series of tracks in the library into a small numbers of disc.
     * Assume First-Fit Descending.
     * Sort all tracks in descending order.
     * When an item arrives, find the first disc into which the track can fit, if any
     *      - If such a disc can be found, the new item is placed inside it.
     *      - Otherwise, creating a new disc and putting the track inside it.
     *
     * @param discCapacity The capacity of each disc.
     * @return A list of disc
     */
    public List<Disc> backUpTracksOnDisc(int discCapacity) {
        List<MusicTrack> tracksArrayList = new ArrayList<>(tracks.values());

        // 1. Sort the tracks in descending order of size
        tracksArrayList.sort((t1, t2) -> Integer.compare(t2.getFileSizeInBytes(), t1.getFileSizeInBytes()));

        List<Disc> discs = new ArrayList<>();

        // 2. For each track
        for (MusicTrack track : tracksArrayList) {
            boolean placed = false;

            // 3. Try to place it in the first disc where it fits
            for (Disc disc : discs) {
                if (disc.canFit(track)) {
                    disc.addTrack(track);
                    placed = true;
                    break;
                }
            }

            // If it doesn't fit in any current disc, create a new disc and place the track in it
            if (!placed) {
                Disc newDisc = new Disc(discCapacity);
                newDisc.addTrack(track);
                discs.add(newDisc);
            }
        }
        return discs;
    }
}
