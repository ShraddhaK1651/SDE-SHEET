Given an array, divide it into two subsets such that:
The absolute difference between their sums is minimum.

  public class MinimumSubsetSumDifference {

    static int minDifference(int[] arr, int n) {

        int totalSum = 0;
        for (int num : arr)
            totalSum += num;

        boolean[][] dp = new boolean[n + 1][totalSum + 1];

        // Initialization
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;

        for (int j = 1; j <= totalSum; j++)
            dp[0][j] = false;

        // Fill DP (Subset Sum logic)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= totalSum; j++) {

                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] 
                               || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int minDiff = Integer.MAX_VALUE;

        // Check only till totalSum/2
        for (int j = 0; j <= totalSum / 2; j++) {
            if (dp[n][j]) {
                minDiff = Math.min(minDiff, totalSum - 2 * j);
            }
        }

        return minDiff;
    }

    public static void main(String[] args) {

        int[] arr = {1, 6, 11, 5};
        int n = arr.length;

        System.out.println(minDifference(arr, n));
    }
}
