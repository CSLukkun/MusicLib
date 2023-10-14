import org.example.Soloist;

import java.util.Random;

public class SoloistTest {

    public static void main(String args[]) {
        generateAnSoloist();
    }


    public static Soloist generateAnSoloist() {
        return new Soloist(generateRandomName());
    }

    public static String generateRandomName() {
        final String[] NAMES = {
                "Smith",
                "Johnson",
                "Brown",
                "Davis",
                "Miller",
                "Wilson",
                "Moore",
                "Taylor",
                "Anderson",
                "Thomas"
        };

        Random random = new Random();

        return NAMES[random.nextInt(NAMES.length)];
    }
}
