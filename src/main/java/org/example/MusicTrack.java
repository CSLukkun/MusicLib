package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MusicTrack implements Comparable<MusicTrack>,Identifier {
    private String trackId;
    private String title;
    private Artist artist;
    private Date date;

    private int lengthInSeconds;
    private int rating;
    private String location;
    private long fileSizeInBytes;
    private List<Artist> guestArtists;
    private int playCount;

    private Album originalAlbum;

    /**
     * Constructs a music track with the given title and artist.
     *
     * @param title  The title of the track.
     * @param artist The primary artist who performed the track.
     */
    public MusicTrack(String title) {
        this.trackId = generateUniqueId();
        this.title = title;
        this.date = null;
        this.lengthInSeconds = 0;
        this.rating = 0;
        this.location = "";
        this.fileSizeInBytes = 0L;
        this.guestArtists = new ArrayList<>();
        this.playCount = 0;
        this.artist = null;
    }


    /**
     * Sets the release date of the track.
     *
     * @param date The release date of the track.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets the release date of the track.
     *
     * @return The release date of the track.
     */
    public Date getDate() {
        return date;
    }

    // Add getters and setters for other attributes (length, rating, location, size)

    /**
     * Adds a guest artist to the track.
     *
     * @param guestArtist The guest artist to be added.
     */
    public void addGuestArtist(Artist guestArtist) {
        guestArtists.add(guestArtist);
    }

    /**
     * Gets a list of all individuals on the track, including band members and guest artists.
     *
     * @return A list of artists on the track.
     */
    public List<Artist> getArtistsOnTrack() {
        List<Artist> allArtists = new ArrayList<>();
        allArtists.add(artist);
        allArtists.addAll(guestArtists);
        return allArtists;
    }

    /**
     * Adds to the play count of the track.
     *
     * @param count The number of plays to be added to the play count.
     */
    public void addToPlayCount(int count) {
        playCount += count;
    }

    /**
     * Gets the play count of the track.
     *
     * @return The play count of the track.
     */
    public int getPlayCount() {
        return playCount;
    }


    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


    public String getTitle() {
        return title;
    }

    /**
     * Gets the album to which the track belongs.
     *
     * @return The album to which the track belongs.
     */
    public Album getOriginalAlbum() {
        return originalAlbum;
    }

    /**
     * Sets the album to which the track belongs and updates the track's reference to the album.
     *
     * @param album The album to which the track belongs.
     */
    public void setOriginalAlbum(Album album) {
        this.originalAlbum = album;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Track: " + title + ", Artist: " + artist.getName() + ", Play Count: " + playCount;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public long getFileSizeInBytes() {
        return fileSizeInBytes;
    }

    public void setFileSizeInBytes(long fileSizeInBytes) {
        this.fileSizeInBytes = fileSizeInBytes;
    }

    public int getLengthInSeconds() {
        return lengthInSeconds;
    }

    public void setLengthInSeconds(int lengthInSeconds) {
        this.lengthInSeconds = lengthInSeconds;
    }

    public String getTrackId() {
        return trackId;
    }

    @Override
    public int compareTo(MusicTrack o) {
        return this.title.compareTo(o.title);
    }

    @Override
    public String generateUniqueId() {
        String timestamp = Long.toString(System.currentTimeMillis());
        String randomUUID = UUID.randomUUID().toString();

        return "track-" + timestamp + "-" + randomUUID;
    }
}