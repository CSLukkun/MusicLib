import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.Album;
import org.example.Artist;
import org.example.MusicTrack;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class TracksTest {

    public static void main(String[] args) {

        // Generate a set of tracks from a json file
        ArrayList<MusicTrack> musicTracks = generateTracksFromJson();
        System.out.println(musicTracks.get(0));

        // Create a track object
        MusicTrack track = new MusicTrack("track 1");
        musicTracks.add(track);

        System.out.println(musicTracks.get(musicTracks.size() - 1));

        track.setArtist(new Artist("Tom"));
        track.setOriginalAlbum(new Album("Golden Life"));
        track.setRating(3);
        track.setPlayCount(100);
        track.setDate(new Date());
        track.setLengthInSeconds(300);
        track.setSavingPath("pathA");
        track.setFileSizeInBytes(5000);

        System.out.println(musicTracks.get(musicTracks.size() - 1));
    }

    public static ArrayList<MusicTrack> generateTracksFromJson() {
        String jsonFilePath = "src/main/resources/tracks.json";

        try (FileReader reader = new FileReader(jsonFilePath)) {
            Type musicTrackListType = new TypeToken<List<MusicTrack>>() {}.getType();

            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd")
                    .create();

            return gson.fromJson(reader, musicTrackListType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static MusicTrack generateAMusicTrack(Artist artist ) {
        String title = generateRandomTitle();
        int rating = new Random().nextInt(6);
        String savingPath = generateRandomSavingPath();
        int playCount = new Random().nextInt(1000);

        MusicTrack musicTrack = new MusicTrack(title);
        musicTrack.setDate(generateRandomDate());
        musicTrack.setArtist(artist);
        musicTrack.setLengthInSeconds(generateRandomPlayingTime());
        musicTrack.setRating(rating);
        musicTrack.setSavingPath(savingPath);
        musicTrack.setFileSizeInBytes(generateRandomSize());
        musicTrack.setPlayCount(playCount);

        return musicTrack;
    }


    public static int generateRandomPlayingTime() {
        return new Random().nextInt(10000);
    }

    public static int generateRandomSize() {
        return new Random().nextInt(1000000);
    }

    public static String generateRandomTitle() {
        final String[] TITLES = {"Title1", "Title2", "Title3", "Title4", "Title5", "Title6", "Title7", "Title8", "Title9", "Title10"};
        final String[] MODIFIER = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        return TITLES[new Random().nextInt(TITLES.length)] + MODIFIER[new Random().nextInt(MODIFIER.length)];
    }

    public static String generateRandomSavingPath() {
        final String[] LOCATIONS = {"pathA", "pathB"};
        return LOCATIONS[new Random().nextInt(LOCATIONS.length)];
    }

    public static Date generateRandomDate() {
        return new Date();
    }
}
