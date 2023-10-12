import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.Artist;
import org.example.MusicTrack;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Random;


public class TracksTest {

    public static void main(String[] args) {
        generateTracks();
    }

    public static void generateTracks() {
        String jsonFilePath = "src/main/resources/tracks.json"; // Replace with the actual JSON file path

        try (FileReader reader = new FileReader(jsonFilePath)) {
            // Define the type of the list of MusicTrack objects using TypeToken
            Type musicTrackListType = new TypeToken<List<MusicTrack>>() {}.getType();

            // Create a Gson object
            Gson gson = new Gson();

            // Deserialize the JSON data into a list of MusicTrack objects
            List<MusicTrack> musicTracks = gson.fromJson(reader, musicTrackListType);

            // Print information for each MusicTrack object in the list
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
        int playingTime = generateRandomPlayingTime();
        int rating = new Random().nextInt(6);
        String location = generateRandomLocation();
        long size = generateRandomSize();
        int playCount = new Random().nextInt(1000);

        MusicTrack musicTrack = new MusicTrack(title);
        musicTrack.setArtist(artist);
        musicTrack.setLengthInSeconds(playingTime);
        musicTrack.setRating(rating);
        musicTrack.setLocation(location);
        musicTrack.setFileSizeInBytes(size);
        musicTrack.setPlayCount(playCount);

        return musicTrack;
    }


    public static int generateRandomPlayingTime() {
        return new Random().nextInt() * 100;
    }

    public static long generateRandomSize() {
        return new Random().nextLong() * 1000000;
    }


    public static String generateRandomTitle() {
        final String[] TITLES = {"Hello", "Bye", "Good", "Bad", "Nice", "Ugly", "Happy", "Sad", "Love", "Hate"};

        return TITLES[new Random().nextInt(TITLES.length)];
    }

    public static String generateRandomLocation() {
        final String[] LOCATIONS = {"pathA", "pathB"};

        return LOCATIONS[new Random().nextInt(LOCATIONS.length)];
    }
}
