package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an artist, including their name and membership to bands if appropriate.
 */
public class Artist {
    private String name;
    private List<String> bandsIn;

    /**
     * Constructs an artist with the given name.
     *
     * @param name The name of the artist.
     */
    public Artist(String name) {


        this.name = name;
        this.bandsIn = new ArrayList<String>();
    }

    /**
     * Adds a band to the list of bands the artist is a part of.
     *
     * @param bandName The name of the band to be added.
     */
    public void addBand(String bandName) {
        bandsIn.add(bandName);
    }

    /**
     * Removes a band from the list of bands the artist is a part of.
     *
     * @param bandName The name of the band to be removed.
     */
    public void removeBand(String bandName) {
        bandsIn.remove(bandName);
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
     * Gets the list of bands the artist is a part of.
     *
     * @return The list of band names.
     */
    public List<String> getBandsIn() {
        return bandsIn;
    }

    /**
     * Returns a formatted string representation of the artist's information.
     *
     * @return A formatted string representing the artist and their bands.
     */
    @Override
    public String toString() {
        StringBuilder artistInfo = new StringBuilder("Artist: " + name);

        if (!bandsIn.isEmpty()) {
            artistInfo.append(", Bands: ");
            for (String band : bandsIn) {
                artistInfo.append(band).append(", ");
            }
            artistInfo.setLength(artistInfo.length() - 2);
        }

        return artistInfo.toString();
    }
}