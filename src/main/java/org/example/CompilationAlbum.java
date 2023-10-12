package org.example;

import java.util.List;

/**
 * Represents a compilation album that may include tracks from various original albums.
 */
public class CompilationAlbum extends Album {
    private List<Album> originalAlbums;

    /**
     * Constructs a compilation album with the given name, type, and artist.
     *
     * @param name          The name of the compilation album.
     * @param type          The type or genre of the compilation album.
     * @param originalAlbums The list of original albums from which tracks are taken.
     */
    public CompilationAlbum(String name, String type, List<Album> originalAlbums) {
        super(name, type, null);
        this.originalAlbums = originalAlbums;
    }

    /**
     * Gets the list of original albums from which tracks are taken.
     *
     * @return The list of original albums.
     */
    public List<Album> getOriginalAlbums() {
        return originalAlbums;
    }
}
