package org.example;
import java.util.UUID;

/**
 * Represents an artist who is a soloist, in a band, or neither.
 *
 * @author Kun Lu
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
     * Set the name of the artist
     *
     * @param name the new name of the arist
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns a formatted string representation of the artist's information.
     *
     * @return A formatted string representing the artist.
     */
    @Override
    public String toString() {
        return "Artist: " + name;
    }

    /**
     * Return a unique artistId to identify the artist.
     *
     * @return A formatted and random string representing the id of the id.
     */
    @Override
    public String generateUniqueId() {
        String timestamp = Long.toString(System.currentTimeMillis());
        String randomUUID = UUID.randomUUID().toString();

        return "artist-" + timestamp + "-" + randomUUID;
    }

    /**
     * Return the id of the artist.
     *
     * @return the id of the artist.
     */
    public String getArtistId() {
        return artistId;
    }
}