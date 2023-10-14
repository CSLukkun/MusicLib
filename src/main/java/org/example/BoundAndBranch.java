package org.example;
import java.util.ArrayList;
import java.util.List;

public class BoundAndBranch {
    private int[] items;
    private int capacity;
    private int bestSolution = Integer.MAX_VALUE;


    public BoundAndBranch(int[] items, int capacity) {
        this.items = items;
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        BoundAndBranch boundAndBranch  = new BoundAndBranch(
                new int[]{5, 3, 7, 2, 6, 8},
                10
        );

        boundAndBranch.calculateOptimalPattern();
    }

    public void calculateOptimalPattern() {

        List<Integer> bins = new ArrayList<>();

        // Initial solution (upper bound) using a simple heuristic
        for (int item : items) {
            boolean packed = false;
            for (int j = 0; j < bins.size(); j++) {
                if (bins.get(j) + item <= capacity) {
                    bins.set(j, bins.get(j) + item);
                    packed = true;
                    break;
                }
            }
            if (!packed) {
                bins.add(item);
            }
        }
        bestSolution = bins.size();

        // Start branch and bound
        branchAndBound(new ArrayList<>(), 0);
        System.out.println("Minimum number of bins required: " + bestSolution);
    }

    public  int lowerBound(ArrayList<Integer> remainingItems) {
        return (int) Math.ceil((double) sum(remainingItems) / capacity);
    }

    public  void branchAndBound(ArrayList<Integer> bins, int itemIndex) {
        if (itemIndex == items.length) {
            bestSolution = Math.min(bestSolution, bins.size());
            return;
        }

        if (bins.size() + lowerBound(getRemainingItems(itemIndex)) >= bestSolution) {
            return;
        }

        int currentItem = items[itemIndex];

        // Try to fit the current item in existing bins
        for (int i = 0; i < bins.size(); i++) {
            if (bins.get(i) + currentItem <= capacity) {
                bins.set(i, bins.get(i) + currentItem);
                branchAndBound(bins, itemIndex + 1);
                bins.set(i, bins.get(i) - currentItem);
            }
        }

        // Try to put the current item in a new bin
        bins.add(currentItem);
        branchAndBound(bins, itemIndex + 1);
        bins.remove(bins.size() - 1);
    }

    public ArrayList<Integer> getRemainingItems(int start) {
        ArrayList<Integer> remaining = new ArrayList<>();
        for (int i = start; i < items.length; i++) {
            remaining.add(items[i]);
        }
        return remaining;
    }

    public int sum(ArrayList<Integer> list) {
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum;
    }
}
