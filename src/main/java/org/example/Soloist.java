package org.example;

/**
 * Represent a soloist.
 * Extends the artist class.
 */
public class Soloist extends Artist {
    /**
     * Constructor for Soloist class
     *
     * @param name The name of the soloist
     */
    public Soloist(String name) {
        super(name);
    }

    /**
     * Return formatted string including soloist#s name.
     *
     * @return the formatted string.
     */
    @Override
    public String toString() {
        return "Soloist: " + name;
    }
}