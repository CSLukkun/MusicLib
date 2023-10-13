package org.example;

import java.util.*;

/**
 * Represents a compilation album that may include tracks from various original albums.
 */
public class CompilationAlbum extends Album {
    private HashMap<String,Album> originalAlbums;
    private HashMap<String,Artist> artists;

    /**
     * Constructs a compilation album with the given name, type, and artist.
     *
     * @param name    The name of the compilation album.
     */
    public CompilationAlbum(String name) {
        super(name);
        artists = new HashMap<>();
        originalAlbums = new HashMap<>();
    }

    /**
     * Gets the list of original albums from which tracks are taken.
     *
     * @return The list of original albums.
     */
    public ArrayList<Album> getOriginalAlbums() {
        return new ArrayList<>(originalAlbums.values());
    }


    @Override
    public void addTrack(MusicTrack track) {
        tracks.add(track.getTrackId());
        originalAlbums.put(track.getOriginalAlbum().getAlbumId(), track.getOriginalAlbum());
        artists.put(track.getArtist().artistId, track.getArtist());
    }

    @Override
    public void removeTrack(MusicTrack track) {
        tracks.remove(track);
        originalAlbums.remove(track.getTrackId());
        artists.remove(track.getArtist().artistId);
    }

    /**
     * Gets the list of artists who have contributed tracks to the compilation album.
     *
     * @return The list of artists.
     */
    public HashMap<String, Artist> getArtists() {
        return artists;
    }

    public HashMap<String,Album> getOriginalAlbumsMap() {
        return originalAlbums;
    }

    @Override
    public String toString() {
        return "AlbumName: " + name+ "\n" + "Tracks: " + "\n" + tracks;
    }
}
