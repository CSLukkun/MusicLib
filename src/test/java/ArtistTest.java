import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.Artist;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ArtistTest {
    public static void main(String[] args) {
       ArrayList<Artist> artists = generateArtistsFromJson();
       System.out.println(artists);

        artists.get(0).setName("Tom");
        System.out.println(artists);
    }

    public static ArrayList<Artist> generateArtistsFromJson() {
        String jsonFilePath = "src/main/resources/artists.json";

        try (FileReader reader = new FileReader(jsonFilePath)) {
            Type artistListType = new TypeToken<ArrayList<Artist>>() {}.getType();

            Gson gson = new Gson();

            return gson.fromJson(reader, artistListType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Artist generatAnArtist() {
        return SoloistTest.generateAnSoloist();
    }
}
