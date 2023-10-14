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
       ArrayList<Album> albums = generateAlbumFromJson();

       Album lastAlbum = albums.get(albums.size() - 1);
       System.out.println(lastAlbum);

       Artist artist = new Artist("Tom");
       lastAlbum.setArtist(artist);

       MusicTrack track = new MusicTrack("track 1");
       track.setArtist(artist);

       lastAlbum.addTrack(track);
       System.out.println("---------");
       System.out.println(lastAlbum);

       System.out.println("---------");
       System.out.println("albumId: " + lastAlbum.getAlbumId());
       System.out.println("artistOfAlbum" + lastAlbum.getArtist());

       ArrayList<MusicTrack> tracks = TracksTest.generateTracksFromJson();
       for(MusicTrack v : tracks) {
           lastAlbum.addTrack(v);
       }



    }

    public static ArrayList<Album> generateAlbumFromJson() {
        String jsonFilePath = "src/main/resources/albums.json";

        try (FileReader fileReader = new FileReader(jsonFilePath)) {

            Type albumListType = new TypeToken<ArrayList<Album>>() {}.getType();

            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd")
                    .create();

            ArrayList<Album> albums = gson.fromJson(fileReader, albumListType);

            return albums;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Album generateAnAlbum() {
        String albumName = generateRandomAlbumName();
        Artist artist = ArtistTest.generatAnArtist();

        Album album = new Album(albumName);
        int trackNum = new Random().nextInt(10) + 5;

        for (int i = 0; i < trackNum; i++) {
            album.addTrack(TracksTest.generateAMusicTrack(artist));
        }
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
