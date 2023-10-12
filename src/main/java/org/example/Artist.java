package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Represents an artist, including their name and membership to bands if appropriate.
 */
public class Artist implements Identifier {
    protected String artistId;
    protected String name;

    /**
     * Constructs an artist with the given name.
     *
     * @param name The name of the artist.
     */
    public Artist(String name) {
        this.artistId = generateUniqueId();
        this.name = name;

    }

    /**
     * Gets the name of the artist.
     *
     * @return The name of the artist.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a formatted string representation of the artist's information.
     *
     * @return A formatted string representing the artist and their bands.
     */
    @Override
    public String toString() {
        StringBuilder artistInfo = new StringBuilder("Artist: " + name);
        return artistInfo.toString();
    }

    @Override
    public String generateUniqueId() {
        String timestamp = Long.toString(System.currentTimeMillis());
        String randomUUID = UUID.randomUUID().toString();

        return "artist-" + timestamp + "-" + randomUUID;
    }
}