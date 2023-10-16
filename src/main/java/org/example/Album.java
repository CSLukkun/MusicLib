package org.example;
import java.util.ArrayList;
import java.util.UUID;


/**
 * Represents an album with information such as albumId, name, type, artist, and a list of tracksId.
 * Implementing the interface with a function generating a unique album id
 *
 * @author Kun Lu
 */
public class Album implements Identifier {
    /**
     * The unique identifier of an album.
     */
    protected String albumId;

    /**
     * The name of the album.
     */
    protected String name;

    /**
     * The type of the album.
     */
    protected AlbumType type;

    /**
     * The list of artist who creating the album
     */
    private Artist artist;

    /**
     * The list of tracks on the album.
     */
    protected ArrayList<MusicTrack> tracks;

    /**
     * Constructor of an album with the given name
     * when creating album object, you provide corresponding name, it will generate a unique albumId, a default artist named
     * no name, a default type referred COMMON, and an arraylist of trackId
     *
     * @param name represent the name of the album
     */
    public Album(String name) {
        this.albumId = generateUniqueId();
        this.artist = new Artist("There is no artist");
        this.name = name;
        this.type = AlbumType.COMMON_ALBUM;
        this.tracks = new ArrayList<>();
    }

    /**
     * Sets the name of the album.
     *
     * @param name the name of the album.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the album.
     *
     * @return the name of the album.
     */
    public String getName() {
        return this.name;
    }

    /**
     * set the artist of the album
     *
     * @param artist the artist issuing the artist
     */
    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    /**
     * get the artist of the album
     *
     * @return the artist issuing the artist
     */
    public Artist getArtist() {
        return artist;
    }

    /**
     * get the id of the album
     *
     * @return the id of the album
     */
    public String getAlbumId() {
        return albumId;
    }

    /**
     * Adds a music track to the album.
     *
     * @param track The track to be added.
     */
    public void addTrack(MusicTrack track) {
        tracks.add(track);
        track.setOriginalAlbum(this);
    }

    /**
     * Remove a music track to the album
     *
     * @param track the track to be removed
     */
    public void removeTrack(MusicTrack track) {
        tracks.remove(track);
    }

    /**
     * Gets the overall time of the album in Seconds.
     *
     * @return The total time of the album.
     */
    public int getTotalTimeOfTracks() {
        int totalTimeOfTracks = 0;

        for (MusicTrack track : tracks) {
            totalTimeOfTracks += track.getLengthInSeconds();
        }

        return totalTimeOfTracks;
    }

    /**
     * Gets the overall file size of the album in bytes.
     *
     * @return The total file size of the album.
     */
    public long getTotalFileSize() {
        long totalFileSize = 0;
        for (MusicTrack track : tracks) {
            totalFileSize += track.getFileSizeInBytes();
        }
        return totalFileSize;
    }

    /**
     * Gets the average rating of tracks on the album.
     *
     * @return The average rating of the album's tracks.
     */
    public double getAverageRating() {
        if (tracks.isEmpty()) {
            return 0.0;
        }

        double totalRating = 0.0;
        for (MusicTrack track : tracks) {
            totalRating += track.getRating();
        }

        // Keep two decimal places for data of type double.
        double value = totalRating / tracks.size();
        return Math.round(value * 100.0) / 100.0 ;
    }

    /**
     * Return A formatted String
     *
     * @return A formatted String including album's name and all tracks
     */
    @Override
    public String toString() {
        return "AlbumName: " + name+ "\n" + "Tracks: " + "\n" + tracks;
    }


    /**
     * Return a unique identifier.
     *
     * @return a unique identifier.
     */
    @Override
    public String generateUniqueId() {
        String timestamp = Long.toString(System.currentTimeMillis());
        String randomUUID = UUID.randomUUID().toString();

        return "album-" + timestamp + "-" + randomUUID;
    }

    /**
     * Gets ids of all tracks
     *
     * @return ids of all tracks
     */
    public ArrayList<MusicTrack> getTracks() {
        return tracks;
    }
}
