import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.Artist;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ArtistTest {
    public static void main(String[] args) {
//        generatAnArtist("soloist");
        generateArtistsFromJson();

    }

    public static ArrayList<Artist> generateArtistsFromJson() {
        String jsonFilePath = "src/main/resources/artists.json";

        try (FileReader reader = new FileReader(jsonFilePath)) {
            // Define the type of the list of artists using TypeToken
            Type artistListType = new TypeToken<List<Artist>>() {}.getType();

            // Create a Gson object
            Gson gson = new Gson();

            // Deserialize the JSON data into a list of Artist objects
            List<Artist> artists = gson.fromJson(reader, artistListType);

            // Print artist information
            return (ArrayList<Artist>) artists;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Artist generatAnArtist(String type)  {
        if (Objects.equals(type, "soloist")) {
            return SoloistTest.generateAnSoloist();
        } else {
            return BandTest.generateABand();
        }
    }

    public static Artist generatAnArtist() {
        return SoloistTest.generateAnSoloist();
    }
}
