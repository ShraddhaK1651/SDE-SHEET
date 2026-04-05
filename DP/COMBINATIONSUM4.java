Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
The test cases are generated so that the answer can fit in a 32-bit integer.
Example 1:
Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.

  class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int j = 1; j <= target; j++) {
            for (int num : nums) {
                if (num <= j) {
                    dp[j] += dp[j - num];
                }
            }
        }

        return dp[target];
    }
}


class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];

        // Base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1; // 1 way to make sum 0
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {

                // exclude current number
                dp[i][j] = dp[i - 1][j];

                // include current number
                if (nums[i - 1] <= j) {
                    dp[i][j] += dp[i][j - nums[i - 1]];
                }
            }
        }

        return dp[n][target];
    }
}
