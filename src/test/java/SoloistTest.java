import org.example.Soloist;

import java.util.Random;

public class SoloistTest {

    public static void main(String[] args) {
        Soloist soloist = generateAnSoloist();
        System.out.println(soloist);

        // Re-set the name of soloist
        soloist.setName(generateRandomName());
        System.out.println(soloist);
    }


    /**
     * Generate a soloist with a random name
     * @return soloist with a random name
     */
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
