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
    private String libId;

    private String name;
    private HashMap<String,MusicTrack> tracks;
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
    }

    /**
     * Removes a music track to the library.
     *
     * @param track The track to be removed.
     */
    public void removeTrack(MusicTrack track) {
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
        albums.put(album.getAlbumId(), album);
        album.getTracks().forEach(track -> this.removeTrack(track));
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

    public HashMap<String,MusicTrack> getAllTracks() {
        return tracks;
    }

    public HashMap<String, Album> getAllAlbums() {
        return albums;
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

    public List<Disc> backUpTracksOnDisc(int discCapacity) {
        List<MusicTrack> tracksArrayList = new ArrayList<>(tracks.values());

        // 1. Sort the tracks in decreasing order of size
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
