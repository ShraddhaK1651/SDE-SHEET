public class CountSubsetWithGivenDifference {
    static int countSubsets(int[] arr, int sum, int n) {

        int[][] dp = new int[n + 1][sum + 1];

        // Initialization
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for (int j = 1; j <= sum; j++)
            dp[0][j] = 0;

        // Fill DP
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {

                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]]
                               + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }

    static int countPartitions(int[] arr, int diff) {

        int totalSum = 0;
        for (int num : arr)
            totalSum += num;

        // Check validity
        if ((diff + totalSum) % 2 != 0)
            return 0;

        int target = (diff + totalSum) / 2;

        return countSubsets(arr, target, arr.length);
    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 2, 3};
        int diff = 1;

        System.out.println(countPartitions(arr, diff));
    }
}
