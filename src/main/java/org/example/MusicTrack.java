package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Represent a track including a series of information about it.
 * Implement of Identifier with a function generating a unique identifier.
 */
public class MusicTrack implements Identifier {
    /**
     * The unique identifier of the track
     */
    private String trackId;

    /**
     * The title of track
     * Alias: the name of track
     */
    private String title;

    /**
     * The artist of the track.
     */
    private Artist artist;

    /**
     * The date of track issuing
     */
    private Date date;

    /**
     * The play time of the track.
     */
    private int lengthInSeconds;

    /**
     * The rating of the track.
     */
    private int rating;

    /**
     * The saving path of the track.
     */
    private String savingPath;

    /**
     * The size of the track
     */
    private int fileSizeInBytes;

    /**
     * The other artists to be invited to create the track.
     */
    private List<Artist> guestArtists;

    /**
     * The play times of the track.
     */
    private int playCount;

    /**
     * Saving data about the album from which the track originates.
     */
    private Album originalAlbum;

    /**
     * Constructs a music track with the given title and artist.
     *
     * @param title  The title of the track.
     */
    public MusicTrack(String title) {
        this.trackId = generateUniqueId();
        this.title = title;
        this.date = null;
        this.lengthInSeconds = 0;
        this.rating = 0;
        this.savingPath = "";
        this.fileSizeInBytes = 0;
        this.guestArtists = new ArrayList<>();
        this.playCount = 0;
        this.artist = new Artist("Unknown");
        this.originalAlbum = new Album("Unknown");
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

    /**
     * Gets the rating of the track from 0 to 5.
     *
     * @return the rating of the track
     */
    public int getRating() {
        return rating;
    }


    /**
     * Sets the rating of the track from 0 to 5.
     *
     * @param rating the rating of the track.
     */
    public void setRating(int rating) {
        if (rating > 5) {
            rating = 5;
        }
        this.rating = rating;
    }

    /**
     * Gets the title of the track.
     *
     * @return the title of the track.
     */
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

    /**
     * Sets the savingPath of the track.
     *
     * @param savingPath the specific savingPath of the track.
     */
    public void setSavingPath(String savingPath) {
        this.savingPath = savingPath;
    }

    /**
     * Gets the savingPath of the track.
     *
     * @return the savingPath of the track.
     */
    public String getSavingPath() {
        return savingPath;
    }

    /**
     * Return the formatted string that includes the track's name, artist, original album name, release date, playtime,
     * rating, save path,size, and play count.
     *
     * @return the formatted string.
     */
    @Override
    public String toString() {
        return  "\n" +
                " TrackName: " + title  + "\n" +
                " Artist: " + artist.name  + "\n" +
                " originalAlbumName: " + getOriginalAlbum().name + "\n" +
                " Date: " + date + "\n" +
                " lengthInSeconds: " + lengthInSeconds + "\n" +
                " Rating: " + rating + "\n" +
                " SavingPath: " + savingPath + "\n" +
                " fileSizeInBytes: " + fileSizeInBytes + "\n" +
                " PlayCount: " + playCount + "\n";
    }

    /**
     * Sets the artist of the track.
     *
     * @param artist the artist to set in this track.
     */
    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    /**
     * Gets the artist of the track.
     *
     * @return the artist of the track.
     */
    public Artist getArtist() {
        return artist;
    }

    /**
     * Set the track's play count.
     *
     * @param playCount the track's play count.
     */
    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    /**
     * Get the size of the track in byte.
     *
     * @return the size of the track
     */
    public int getFileSizeInBytes() {
        return fileSizeInBytes;
    }

    /**
     * Set the size of the track in byte.
     *
     * @param fileSizeInBytes the size of the track in byte.
     */
    public void setFileSizeInBytes(int fileSizeInBytes) {
        this.fileSizeInBytes = fileSizeInBytes;
    }


    /**
     * Get the time of the track in second.
     *
     * @return the time of the track in seconds.
     */
    public int getLengthInSeconds() {
        return lengthInSeconds;
    }

    /**
     * Set the time of the track in second.
     *
     * @param lengthInSeconds the time of the track.
     */
    public void setLengthInSeconds(int lengthInSeconds) {
        this.lengthInSeconds = lengthInSeconds;
    }


    /**
     * Gets the id of the track.
     *
     * @return the id of the track.
     */
    public String getTrackId() {
        return trackId;
    }


    /**
     * Compare the track with other track based on their titles.
     *
     * @param o The track to compare with
     * @return A negative integer, zero, or a positive integer as this title is less than, equal to, or greater than the
     * specified title.
     */
    public int compareTo(MusicTrack o) {
        return this.title.compareTo(o.title);
    }

    /**
     * Generate a trackId for a track using a combination of current timestamp and a random uuid.
     * The format of the unique ID is: "track-{currentTimestamp}-{randomUUID}"
     *
     * @return A unique ID string for the MusicTrack
     */
    @Override
    public String generateUniqueId() {
        String timestamp = Long.toString(System.currentTimeMillis());
        String randomUUID = UUID.randomUUID().toString();
        return "track-" + timestamp + "-" + randomUUID;
    }

    /**
     * Judge if there is original album for the track
     * By judge if the name is equal to "unknown"
     *
     * @return True if the name is equal to "unknown", return, otherwise return false.
     */
    public boolean isExistOriginalAlbum() {
        return this.originalAlbum.getName().equals("unknown");
    }
}