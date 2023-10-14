import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinPackingTest {

    public static void main(String[] args) {
        int[] items = {2, 3,4,4, 5, 6, 7, 8, 9, 10};
        int capacity = 10;

        System.out.println("bruteBinPacking: " + bruteBinPacking(items, capacity));
    }

    public static void sortDescending(int[] items) {
        Arrays.sort(items);

        for (int i = 0; i < items.length / 2; i++) {
            int temp = items[i];
            items[i] = items[items.length - i - 1];
            items[items.length - i - 1] = temp;
        }
    }

    public static int bruteBinPacking(int[] items, int capacity) {

        if (items.length == 0) {
            return 0;
        }

        // create bins
        sortDescending(items);


        // create binSize
        int binSize = 0;

        // create binCount
        int binCount = 1;

        // iterate bins
        for (int i = 0; i < items.length; i++) {

            if (binSize + items[i] > capacity) {
                binCount++;
                binSize = 0;
            }
            binSize += items[i];
        }
        return binCount;
    }

    public static int lowerBound(ArrayList<Integer> remainingTack, int capacity) {
        return (int) Math.ceil((double) sum(remainingTack) / capacity);
    }

//    public static void branchAndBound(List<Integer> bins, int trackIndex, int[] tracks) {
//        if (trackIndex == tracks.length) {
//            returm es
//        }
//    }

    public static int sum(List<Integer> list) {
        int sum = 0;
        for(int item : list) {
            sum += item;
        }

        return sum;
    }
}





