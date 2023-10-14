import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BinPackingTest {

    public static void main(String[] args) {
        int[] items = {2, 3,4,4, 5, 6, 7, 8, 9, 10};
        int capacity = 10;

        System.out.println("bruteBinPacking: " + bruteBinPacking(items, capacity));
        System.out.println("recursiveBinPacking: " + recursiveBinPacking(items, capacity));
        System.out.println("dpBinPacking: " + dpBinPacking(capacity, items.length - 1, items));
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

    public static int dfsBinPacking(int[] itemSizes, int remainingCapacity, int currentIndex){
        if (currentIndex >= itemSizes.length) {
            return 0;
        }

        // Try putting the current item in a new container
        int newContainer = dfsBinPacking(itemSizes, remainingCapacity, currentIndex + 1) + 1;

        // Try putting the current item in the current container if it fits
        int currentItem = itemSizes[currentIndex];
        int useCurrentContainer = Integer.MAX_VALUE;
        if (currentItem <= remainingCapacity) {
            useCurrentContainer = dfsBinPacking(itemSizes, remainingCapacity - currentItem, currentIndex + 1);
        }

        // Return the minimum of the two cases
        return Math.min(newContainer, useCurrentContainer);
    }

    public static int recursiveBinPacking(int[] items, int capacity) {
        if (items.length == 0) {
            return 0;
        }

        return dfsBinPacking(items, capacity, 0) + 1;
    }

    public static int dpBinPacking(int m, int n, int[] w) {
        int[] f = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= w[i]; j--) {
                if (f[j] < f[j - w[i]] + w[i]) {
                    f[j] = f[j - w[i]] + w[i];
                }
            }
        }

        return m - f[m];
    }
}





