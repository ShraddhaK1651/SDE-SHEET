public class Classroom {

    public static int knapsack(int val[], int wt[], int W, int n) {

        // Base Case
        if (W == 0 || n == 0) {
            return 0;
        }

        // Valid case (weight fits)
        if (wt[n - 1] <= W) {

            // Include
            int ans1 = val[n - 1] + knapsack(val, wt, W - wt[n - 1], n - 1);

            // Exclude
            int ans2 = knapsack(val, wt, W, n - 1);

            return Math.max(ans1, ans2);

        } else { // Not valid (weight exceeds capacity)

            return knapsack(val, wt, W, n - 1);
        }
    }

    public static void main(String args[]) {

        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;

        System.out.println(knapsack(val, wt, W, val.length));
    }
}



MEMOIZATION CODE


import java.util.Arrays;

public class KnapsackMemoization {

    static int[][] dp;

    static int knapsack(int[] wt, int[] val, int W, int n) {

        // Base Condition
        if (n == 0 || W == 0)
            return 0;

        // If already calculated
        if (dp[n][W] != -1)
            return dp[n][W];

        // Choice Diagram
        if (wt[n - 1] <= W) {
            dp[n][W] = Math.max(
                    val[n - 1] + knapsack(wt, val, W - wt[n - 1], n - 1),  // include
                    knapsack(wt, val, W, n - 1)                            // exclude
            );
        } else {
            dp[n][W] = knapsack(wt, val, W, n - 1);
        }

        return dp[n][W];
    }

    public static void main(String[] args) {

        int[] wt = {1, 3, 4, 5};
        int[] val = {1, 4, 5, 7};
        int W = 7;
        int n = wt.length;

        dp = new int[n + 1][W + 1];

        // Initialize with -1
        for (int[] row : dp)
            Arrays.fill(row, -1);

        System.out.println("Maximum Profit = " + knapsack(wt, val, W, n));
    }
}
