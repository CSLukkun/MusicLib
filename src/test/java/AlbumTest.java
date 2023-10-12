import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.example.Album;
import org.example.AlbumType;
import org.example.Artist;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AlbumTest {
    public static void main(String[] args) {
       generateAnAlbum();
    }

    public static void generateAlbumFromJson() {
        String jsonFilePath = "src/main/resources/albums.json";

        try (FileReader fileReader = new FileReader(jsonFilePath)) {
            // Parse the JSON file using Gson
            JsonElement jsonElement = JsonParser.parseReader(fileReader);
            JsonArray jsonArray = jsonElement.getAsJsonArray();

            // Create a list to store Album objects
            List<Album> albums = new ArrayList<>();

            // Iterate through the JSON array and create Album objects
            for (JsonElement albumElement : jsonArray) {
                JsonObject albumObject = albumElement.getAsJsonObject();

                // Extract album properties from JSON
                String albumName = albumObject.get("name").getAsString();
                AlbumType albumType = AlbumType.valueOf(albumObject.get("type").getAsString());
                JsonObject artistObject = albumObject.get("artist").getAsJsonObject();

                // Extract artist properties from JSON
                String artistName = artistObject.get("name").getAsString();

                // Create an Artist object
                Artist artist = new Artist(artistName);

                // Create an Album object and add it to the list
                Album album = new Album(albumName);
                albums.add(album);
            }

            // Now you have a list of Album objects
            // You can use the albums list in your application
            for (Album album : albums) {
                System.out.println(album);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Album generateAnAlbum() {
        String albumName = generateRandomAlbumName();
        AlbumType albumType = AlbumType.valueOf(generateRandomAlbumType());
        Artist artist = ArtistTest.generatAnArtist();

        Album album = new Album(albumName);
        int trackNum = new Random().nextInt(10) + 5;
        for (int i = 0; i < trackNum; i++) {
            album.addTrack(TracksTest.generateAMusicTrack(artist));
        }
        System.out.println(album);
        return album;
    }


    public static String generateRandomAlbumType() {
        final String[] albumTypes = {
                "FULL_ALBUM",
                "MINI_ALBUM",
                "COMPILATION_ALBUM"
        };
        Random random = new Random();
        int randomIndex = random.nextInt(albumTypes.length);
        return albumTypes[randomIndex];
    }

    public static String generateRandomAlbumName() {
        String[] commonAlbumNames = {
                "Greatest Hits",
                "The Best of Artisti",
                "Live in Newcastle",
                "Unplugged",
                "Acoustic Sessions",
                "Back to Basics",
                "All Time Favorites",
                "Eponymous",
                "Into the Wild",
                "Songs of Love and Heartbreak",
                "Lost and Found",
                "Midnight Serenade",
                "Summer Vibes",
                "Reflections",
                "The Journey Begins",
                "Legends Never Die",
                "Rhythms of the World",
                "In My Dreams",
                "Echoes of the Past",
                "Soulful Journeys"
        };

        Random random = new Random();
        int randomIndex = random.nextInt(commonAlbumNames.length);
        return commonAlbumNames[randomIndex];
    }
}
