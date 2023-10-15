import com.google.gson.Gson;
import org.example.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LibraryTest {
    public static void main(String[] args) {
        MusicLibrary library = new MusicLibrary("Library 1");

        // Generate mocked tracks from a json file.
        ArrayList<MusicTrack> musicTracks = TracksTest.generateTracksFromJson();

        for (MusicTrack track: musicTracks) {
            library.addTrack(track);
        }

        // Print all tracks in the lib
        System.out.println("All tracks are" + library.getAllTracks());

        // Get the lowest rating in the lib
        ArrayList<MusicTrack> tracksWithLowestRating = library.getTracksWithLowestRating();
        System.out.println("List all tracks with the lowest rating " + tracksWithLowestRating);

        // Generate mocked albums from a json file.
        ArrayList<Album> albums = AlbumTest.generateAlbumFromJson();

        for (Album album: albums) {
            library.addAlbum(album);
        }

        // Print all albums in the lib
        System.out.println("All albums are" + library.getAllAlbums());

        saveToStringToFile("library.txt", String.valueOf(library));
        saveToJsonToFile("library.json", library);
    }

    public static void saveToStringToFile(String filename, String data) {
        final String PATH = "src/test/output/";
        String filePath = PATH + filename;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveToJsonToFile(String filename, MusicLibrary lib) {
        final String PATH = "src/test/output/";
        String filePath = PATH + filename;

        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(lib, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}