package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Random;

public class ArtistTest {
    public static void main(String[] args) {
        generatAnArtist();

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

    public static Artist generatAnArtist()  {
        final int MAX_BAND_NUMS = 5;
        String name = generateRandomName();

        Artist artist = new Artist(name);

        int bandLen = new Random().nextInt(MAX_BAND_NUMS);
        for (int i = 0; i < bandLen; i++) {
            artist.addBand(generateRandomBandName());
        }

        return artist;
    }


    public static String generateRandomName() {
        final String[] FIRST_NAMES = {"John", "Mary", "David", "Lisa", "Michael", "Jennifer", "James", "Emily", "Robert", "Jessica"};
        final String[] LAST_NAMES = {"Smith", "Johnson", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor", "Anderson", "Thomas"};

        Random random = new Random();
        String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        return firstName + " " + lastName;
    }


    public static String generateRandomBandName() {
        final String[] ADJECTIVES = {"Rocking", "Electric", "Funky", "Groovy", "Epic", "Wild", "Sonic", "Awesome", "Soulful", "Mystic"};
        final String[] NOUNS = {"Journey", "Harmony", "Rhythm", "Beat", "Groove", "Vibes", "Melody", "Fusion", "Sound", "Jam"};

        Random random = new Random();
        String adjective = ADJECTIVES[random.nextInt(ADJECTIVES.length)];
        String noun = NOUNS[random.nextInt(NOUNS.length)];
        return adjective + " " + noun;
    }
}
