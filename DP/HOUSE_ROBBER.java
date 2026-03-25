You are given an array nums where each element represents money in a house.

👉 Task:
Find the maximum amount of money you can rob such that no two adjacent houses are robbed.
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int prev = nums[0];   // dp[i-1]
        int prev2 = 0;        // dp[i-2]

        for (int i = 1; i < n; i++) {
            int pick = nums[i] + prev2;
            int notPick = prev;

            int cur = Math.max(pick, notPick);

            prev2 = prev;
            prev = cur;
        }

        return prev;
    }
}
