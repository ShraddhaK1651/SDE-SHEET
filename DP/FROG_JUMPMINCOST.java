Problem Summary (Frog Jump – Min Cost)
You are given an array heights[], where each element represents the height of a stone.
A frog starts at index 0 and wants to reach the last index.
⚡ Rules
The frog can jump:
1 step ahead, or
2 steps ahead
The cost of a jump from index i to j is:
|heights[i] - heights[j]
Return the minimum total cost required to reach the last index.

public class FrogJumpOptimized {

    public static int frogJump(int[] heights) {
        int n = heights.length;

        int prev = 0;   // dp[i-1]
        int prev2 = 0;  // dp[i-2]

        for (int i = 1; i < n; i++) {

            int left = prev 
                    + Math.abs(heights[i] - heights[i - 1]);

            int right = Integer.MAX_VALUE;
            if (i > 1) {
                right = prev2 
                      + Math.abs(heights[i] - heights[i - 2]);
            }

            int curr = Math.min(left, right);

            prev2 = prev;
            prev = curr;
        }

        return prev;
    }

    public static void main(String[] args) {
        int[] heights = {10, 20, 30, 10};
        System.out.println(frogJump(heights));
    }
}
