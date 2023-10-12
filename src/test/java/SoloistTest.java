import org.example.Soloist;

import java.util.Random;

public class SoloistTest {

    public static void main(String args[]) {
        generateAnSoloist();
    }


    public static Soloist generateAnSoloist() {
        Soloist soloist = new Soloist(generateRandomName());
        return soloist;
    }

    public static String generateRandomName() {
        final String[] FIRST_NAMES = {"John", "Mary", "David", "Lisa", "Michael", "Jennifer", "James", "Emily", "Robert", "Jessica"};
        final String[] LAST_NAMES = {"Smith", "Johnson", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor", "Anderson", "Thomas"};

        Random random = new Random();
        String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        return firstName + " " + lastName;
    }
}
