import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.Artist;
import org.example.MusicTrack;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.Random;


public class TracksTest {

    public static void main(String[] args) {
        generateTracks();
    }

    public static void generateTracks() {
        String jsonFilePath = "src/main/resources/tracks.json"; // Replace with the actual JSON file path

        try (FileReader reader = new FileReader(jsonFilePath)) {
            Type musicTrackListType = new TypeToken<List<MusicTrack>>() {}.getType();

            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd")
                    .create();

            List<MusicTrack> musicTracks = gson.fromJson(reader, musicTrackListType);

            for (MusicTrack musicTrack : musicTracks) {
                System.out.println("Title: " + musicTrack.getTitle());
                System.out.println("Artist: " + musicTrack.getArtist());
                System.out.println("Date: " + musicTrack.getDate());
                System.out.println("Length: " + musicTrack.getLengthInSeconds());
                System.out.println("Rating: " + musicTrack.getRating());
                System.out.println("Location: " + musicTrack.getLocation());
                System.out.println("Size: " + musicTrack.getFileSizeInBytes());
                System.out.println("Play Count: " + musicTrack.getPlayCount());
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static MusicTrack generateAMusicTrack(Artist artist ) {
        String title = generateRandomTitle();
        int rating = new Random().nextInt(6);
        String location = generateRandomLocation();
        int playCount = new Random().nextInt(1000);

        MusicTrack musicTrack = new MusicTrack(title);
        musicTrack.setDate(generateRandomDate());
        musicTrack.setArtist(artist);
        musicTrack.setLengthInSeconds(generateRandomPlayingTime());
        musicTrack.setRating(rating);
        musicTrack.setLocation(location);
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
        final String[] MODIFER = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        return TITLES[new Random().nextInt(TITLES.length)] + MODIFER[new Random().nextInt(MODIFER.length)];
    }

    public static String generateRandomLocation() {
        final String[] LOCATIONS = {"pathA", "pathB"};
        return LOCATIONS[new Random().nextInt(LOCATIONS.length)];
    }

    public static Date generateRandomDate() {
        return new Date();
    }

}
