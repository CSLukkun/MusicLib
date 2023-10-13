import org.example.Artist;
import org.example.Band;
import java.util.Random;

public class BandTest {

    public static void main(String args[]) {
        removeMemberById();
    }

    public static void addMember() {
        Band band = generateABand();
        Artist artist = new Artist("John");
        band.addMember(artist);
        System.out.println(band);
    }

    public static void removeMember() {
        Band band = generateABand();
        Artist artist = new Artist("John");
        band.addMember(artist);
        System.out.println(band);
        band.removeMember(artist);
        System.out.println(band);
    }

    public static void removeMemberById(){
        Band band = generateABand();
        Artist artist = new Artist("John");
        Artist artist1 = new Artist("Tom");
        band.addMember(artist);
        band.addMember(artist1);
        System.out.println(band);
        band.removeMemberById(artist.getArtistId());
        System.out.println(band);
    }

    public static Band generateABand() {
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
