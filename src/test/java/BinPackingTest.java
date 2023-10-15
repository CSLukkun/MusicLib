import org.example.BoundAndBranch;

public class BinPackingTest {

    public static void main(String[] args) {
        BoundAndBranch boundAndBranch = new BoundAndBranch(
                new int[]{5, 3, 7, 2, 6, 8},
                10
        );

        boundAndBranch.calculateOptimalPattern();
    }
}