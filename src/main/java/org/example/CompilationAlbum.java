package org.example;

import java.util.*;

/**
 * Represents a compilation album that may include tracks from various original albums.
 * Extend the Album class with specific and additional function.
 */
public class CompilationAlbum extends Album {
    /**
     * A map holding a collection of music albums, where the key represent the unique
     * identifier or name of the album, and the values is the music album object itself.
     */
    private HashMap<String,Album> originalAlbums;

    /**
     * A map holding a collection of artists, where the key represent the unique identifier or name
     * of the album, and the values is the music album object itself.
     */
    private HashMap<String,Artist> artists;

    /**
     * Constructor of a compilation album with the given name, type, and artist.
     *
     * @param name The name of the compilation album.
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

    /**
     * Adds a specific track to the compilation album.
     *
     * @param track The track to be added.
     */
    @Override
    public void addTrack(MusicTrack track) {
        tracks.add(track);
        originalAlbums.put(track.getOriginalAlbum().getAlbumId(), track.getOriginalAlbum());
        artists.put(track.getArtist().artistId, track.getArtist());
    }

    /**
     * Remove a specific track to the compilation album.
     *
     * @param track the track to be removed
     */
    @Override
    public void removeTrack(MusicTrack track) {

        int originalReferring = 0;
        for(int i = 0; i < tracks.size(); i++) {
            if (Objects.equals(track.getOriginalAlbum().getAlbumId(), tracks.get(i).getOriginalAlbum().getAlbumId())) {
                originalReferring++;
            }
        }
        if (originalReferring <= 1) {
            originalAlbums.remove(track.getOriginalAlbum().getAlbumId());
        }

        int artistReferring = 0;
        List<Artist> artistsArray = new ArrayList<>(artists.values());
        for(int i = 0; i < artistsArray.size(); i++) {
            if (Objects.equals(track.getArtist().getArtistId(), artistsArray.get(i).getArtistId())) {
                artistReferring++;
            }
        }

        if (artistReferring <= 1) {
            artists.remove(track.getArtist().getArtistId());
        }

        tracks.remove(track);
    }

    /**
     * Gets the list of artists who have contributed tracks to the compilation album.
     *
     * @return The list of artists.
     */
    public HashMap<String, Artist> getArtists() {
        return artists;
    }

    /**
     * Gets the list of original Albums which have contributed tracks to the compilation album.
     *
     * @return The list of albums.
     */
    public HashMap<String,Album> getOriginalAlbumsMap() {
        return originalAlbums;
    }

    /**
     * Return formatted string including compilation name and corresponding tracks.
     *
     * @return the formatted string.
     */
    @Override
    public String toString() {
        return "AlbumName: " + name+ "\n" + "Tracks: " + "\n" + tracks;
    }
}
