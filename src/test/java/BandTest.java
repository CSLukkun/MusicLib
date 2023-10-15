import org.example.Artist;
import org.example.Band;
import org.example.Soloist;

import java.util.Random;

public class BandTest {

    public static void main(String[] args) {

        // Construct a band
        Band band = new Band(generateRandomBandName());
        System.out.println(band);

        // Construct a artist Alice
        Artist alice = new Artist("Alice");

        // Construct a soloist Bob
        Soloist bob = new Soloist("Bob");

        // This band add two artist
        band.addMember(alice);
        band.addMember(bob);

        // Print all members in the band
        System.out.println("All members in the band is " + band.getMembers());

        // Remove alice
        band.removeMember(alice);
        System.out.println("All members in the band is " + band.getMembers());

        // Remove bob by artist id
        band.removeMemberById(bob.getArtistId());
        System.out.println("All members in the band is " + band.getMembers());
    }

    /**
     * Generate a band name.
     *
     * @return a random band name
     */
    public static String generateRandomBandName() {
        final String[] ADJECTIVES = {"Rocking", "Electric", "Funky", "Groovy", "Epic", "Wild", "Sonic", "Awesome", "Soulful", "Mystic"};
        final String[] NOUNS = {"Journey", "Harmony", "Rhythm", "Beat", "Groove", "Vibes", "Melody", "Fusion", "Sound", "Jam"};

        Random random = new Random();
        String adjective = ADJECTIVES[random.nextInt(ADJECTIVES.length)];
        String noun = NOUNS[random.nextInt(NOUNS.length)];
        return adjective + " " + noun;
    }
}
