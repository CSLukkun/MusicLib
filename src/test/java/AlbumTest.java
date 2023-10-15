import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.example.Album;
import org.example.Artist;
import org.example.MusicTrack;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Random;

public class AlbumTest {
    public static void main(String[] args) {
       // Generate a set of albums from json file.
       ArrayList<Album> albums = generateAlbumFromJson();

       // Get the last album.
       Album lastAlbum = albums.get(albums.size() - 1);
       System.out.println(lastAlbum);

       // Construct a new Artist named Tom.
       Artist artist = new Artist("Tom");

       // Assign the artist for the latest album.
       lastAlbum.setArtist(artist);

       // Construct a new track named "tack1".
       MusicTrack track = new MusicTrack("track 1");

       // Assign the artist for the track.
       track.setArtist(artist);

       // Add a tracked assigned by artist in the latest album.
       lastAlbum.addTrack(track);
       System.out.println("---------");
       System.out.println(lastAlbum);

       System.out.println("---------");
       System.out.println("albumId: " + lastAlbum.getAlbumId());
       System.out.println("artistOfAlbum" + lastAlbum.getArtist());

       // Generate a set of tracks from a json file.
       ArrayList<MusicTrack> tracks = TracksTest.generateTracksFromJson();

       // Add all tracks into the latest album.
       for(MusicTrack v : tracks) {
           lastAlbum.addTrack(v);
       }

       // Get the average rating of all tracks in the latest album.
       double averageRating = lastAlbum.getAverageRating();
       System.out.println("The average rating of album is " + averageRating);

       // Modify the rating of the latest track in album, and then print average rating again.
       int size = lastAlbum.getTracks().size();
       MusicTrack latestTrack = lastAlbum.getTracks().get(size - 1);
       latestTrack.setRating(5);
       System.out.println("The average rating of album is " + lastAlbum.getAverageRating());

       // Remove a track
       System.out.println("The number of tracks in the album is " + lastAlbum.getTracks().size());
       lastAlbum.removeTrack(latestTrack);
       System.out.println("After removing a track, the number of the tracks in the album is " + lastAlbum.getTracks().size());

       // Print total time of all tracks.
       System.out.println("The total time of tracks in the last album is " + lastAlbum.getTotalTimeOfTracks() + "seconds");

       // Print total size of all tracks.
       System.out.println("The total size of track in the last album is " + lastAlbum.getTotalFileSize() + "byte" );
    }

    public static ArrayList<Album> generateAlbumFromJson() {

        // Set the location to save.
        String jsonFilePath = "src/main/resources/albums.json";

        try (FileReader fileReader = new FileReader(jsonFilePath)) {
            // Define the type of the list to which the JSON content will be deserialized.
            Type albumListType = new TypeToken<ArrayList<Album>>() {}.getType();

            // Configure the Gson instance to parse date strings in the format "yyyy-MM-dd".
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd")
                    .create();
            // Deserialized the JSON content into a list of album objects and return it.
            return gson.fromJson(fileReader, albumListType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
