package org.example;

import java.util.*;

/**
 * Represents a compilation album that may include tracks from various original albums.
 */
public class CompilationAlbum extends Album {
    private HashMap<String,Album> originalAlbums;
    private HashSet<Artist> artists;

    /**
     * Constructs a compilation album with the given name, type, and artist.
     *
     * @param name    The name of the compilation album.
     * @param type    The type or genre of the compilation album.
     */
    public CompilationAlbum(String name) {
        super(name);
        artists = new HashSet<Artist>();
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
        tracks.add(track);
        originalAlbums.put(track.getTrackId(), track.getOriginalAlbum());
        artists.add(track.getArtist());
    }

    @Override
    public void removeTrack(MusicTrack track) {
        tracks.remove(track);
        originalAlbums.remove(track.getTrackId());
        artists.remove(track.getArtist());
    }
}
