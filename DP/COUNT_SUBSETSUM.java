Given: int[] arr,int sum
Return:
👉 Number of subsets whose total = sum

Each element can be used only once (0/1 type).
dp[i][j] = number of subsets using first i elements that make sum j
class Solution {

    public int countSubsets(int[] arr, int sum) {
        int n = arr.length;

        int[][] dp = new int[n + 1][sum + 1];

        // Base case: sum = 0 → one subset (empty set)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {

                // Exclude current element
                dp[i][j] = dp[i - 1][j];

                // Include current element
                if (arr[i - 1] <= j) {
                    dp[i][j] += dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        return dp[n][sum];
    }
}

Final Complete DP Table
	0	1	2	3	4	5	6	7	8	9	10
0	1	0	0	0	0	0	0	0	0	0	0
1	1	0	1	0	0	0	0	0	0	0	0
2	1	0	1	1	0	1	0	0	0	0	0
3	1	0	1	1	0	2	0	1	1	0	1
4	1	0	1	1	0	2	1	1	2	1	1
5	1	0	1	1	0	2	1	1	3	1	2
6	1	0	1	1	0	2	1	1 3 1 3
