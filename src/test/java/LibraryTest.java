import com.google.gson.Gson;
import org.example.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class LibraryTest {
    public static void main(String[] args) {
        MusicLibrary library = testAddCompilationAlbumsInLibrary();
        System.out.println(library);
        ArrayList<MusicTrack> lowestRat = library.getTracksWithLowestRating();
        System.out.println(lowestRat);
        saveToStringToFile("library.txt", String.valueOf(lowestRat));

        saveToJsonToFile("library.json", library);

    }

    public static MusicLibrary generateALibrary() {
        return new MusicLibrary("library");
    }

    public static void testAddTracksInLibrary() {
        MusicLibrary library = generateALibrary();

        Artist artist = new Artist("John");

        MusicTrack track = TracksTest.generateAMusicTrack(artist);

        library.addTrack(track);

        System.out.println(library);
    }

    public static void testAddAlbumsInLibrary() {
        MusicLibrary library = generateALibrary();

        Artist artist = new Artist("John");

        Album album = AlbumTest.generateAnAlbum();

        library.addAlbum(album);

        System.out.println(library);
    }

    public static MusicLibrary testAddCompilationAlbumsInLibrary() {
        MusicLibrary library = generateALibrary();


        CompilationAlbum compilationAlbum = CompilationAlbumTest.generateCompilationAlbum();

        final int size = 10;

        for (int i = 0; i < size; i++) {
            Artist artist = ArtistTest.generatAnArtist();
            Album album = AlbumTest.generateAnAlbum();
            MusicTrack track = TracksTest.generateAMusicTrack(artist);
            album.addTrack(track);
            library.addTrack(track);

            compilationAlbum.addTrack(track);
        }

        Album album1 = AlbumTest.generateAnAlbum();

        library.addAlbum(compilationAlbum);
        library.addAlbum(album1);

        return library;
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
