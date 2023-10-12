import org.example.Band;
import java.util.Random;


public class BandTest {

    public static void main(String args[]) {
        System.out.println(
                generateBand()
        );
    }

    public static Band generateBand() {
        return new Band(generateRandomBandName());
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
