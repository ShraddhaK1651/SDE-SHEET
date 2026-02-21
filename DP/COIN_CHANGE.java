You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.
Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

  class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        // Base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int j = 1; j <= amount; j++) {
            dp[0][j] = Integer.MAX_VALUE - 1;
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {

                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(
                        dp[i][j - coins[i - 1]] + 1,  // take coin
                        dp[i - 1][j]                  // not take
                    );
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        if (dp[n][amount] >= Integer.MAX_VALUE - 1)
            return -1;

        return dp[n][amount];
    }
}
