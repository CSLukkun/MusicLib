package org.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;


/**
 * Represents an album with information such as albumId, name, type, artist, and a list of tracksId.
 * Implementing the interface with a function generating a unique album id
 *
 * @author Kun Lu
 */
public class Album implements Identifier {
    protected String albumId;
    protected String name;
    protected AlbumType type;
    private Artist artist;
    protected ArrayList<String> tracks;

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
        tracks.add(track.getTrackId());
    }

    /**
     * Remove a music track to the album
     *
     * @param track the track to be removed
     */
    public void removeTrack(MusicTrack track) {
        tracks.remove(track.getTrackId());
    }

    /**
     * Gets the overall time of the album in Seconds.
     *
     * @return The total time of the album.
     */
    public int getTotalTimeOfTracks(ArrayList<MusicTrack> tracks) {
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
    public long getTotalFileSize(ArrayList<MusicTrack> tracks) {
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
    public double getAverageRating(ArrayList<MusicTrack> tracks) {
        if (tracks.isEmpty()) {
            return 0.0;
        }

        double totalRating = 0.0;
        for (MusicTrack track : tracks) {
            totalRating += track.getRating();
        }

        return totalRating / tracks.size();
    }

    /**
     *  Sorts the list of tracks in ascending order by their names.
     *
     */
    public void sortTracksByName() {
        Collections.sort(tracks);
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
    public ArrayList<String> getTracks() {
        return tracks;
    }
}
