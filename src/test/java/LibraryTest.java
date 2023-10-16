import com.google.gson.Gson;
import org.example.*;

import javax.sound.midi.Track;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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

        // Test backing up
        testBackUpBinPacking();
        saveToStringToFile("backupStrategy.txt", testBackUpBinPacking());

        // Test removing a track in lib.
        MusicLibrary library1 = new MusicLibrary("lib1");
        MusicTrack track = new MusicTrack("track 1");
        Album album = new Album("album1");
        album.addTrack(track);

        CompilationAlbum compilationAlbum = new CompilationAlbum("compilationAlbum");
        compilationAlbum.addTrack(track);

        library1.addAlbum(album);
        library1.addAlbum(compilationAlbum);

        library1.removeAlbum(album);
        System.out.println(library1.getAllTracks().size());
        library1.removeTrack(track);
        System.out.println(library1.getAllTracks().size());
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

    public static String testBackUpBinPacking() {
        MusicLibrary lib = new MusicLibrary("lib");

        for (int i = 0; i < 10; i++) {
            MusicTrack track = new MusicTrack("track " + i);
            track.setFileSizeInBytes(new Random().nextInt(10000) + 500);
            lib.addTrack(track);
        }


        List<Disc> discs = lib.backUpTracksOnDisc(10000 + 500);
        System.out.println(discs);

        List<MusicTrack> tracksArrayList = new ArrayList<>(lib.getAllTracks());

        tracksArrayList.sort((s1,s2) -> Integer.compare(s2.getFileSizeInBytes(), s1.getFileSizeInBytes()));
        return "The size of track in descending: " +
                (tracksArrayList.stream().map(v -> v.getFileSizeInBytes()).collect(Collectors.toList()))
                + "\n You need " + discs.size() + "discs"
                + "\n" + String.valueOf(discs);
    }
}