import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.Artist;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;
import java.util.Random;


public class ArtistTest {
    public static void main(String[] args) {
        System.out.println(
                generatAnArtist("soloist")
        );

    }

    public static void generateArtistsFromJson() {
        String jsonFilePath = "src/main/resources/artists.json";

        try (FileReader reader = new FileReader(jsonFilePath)) {
            // Define the type of the list of artists using TypeToken
            Type artistListType = new TypeToken<List<Artist>>() {}.getType();

            // Create a Gson object
            Gson gson = new Gson();

            // Deserialize the JSON data into a list of Artist objects
            List<Artist> artists = gson.fromJson(reader, artistListType);

            // Print artist information
            for (Artist artist : artists) {
                System.out.println(artist);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Artist generatAnArtist(String type)  {
        if (Objects.equals(type, "soloist")) {
            return SoloistTest.generateAnSoloist();
        } else {
            return BandTest.generateBand();
        }
    }


    public static Artist generatAnArtist() {
        return SoloistTest.generateAnSoloist();
    }
}
