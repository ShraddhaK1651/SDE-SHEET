Given: int[] arr,int sum
Return:
👉 Number of subsets whose total = sum

Each element can be used only once (0/1 type).
dp[i][j] = number of subsets using first i elements that make sum j

public class CountSubsetSum {

    static int countSubsets(int[] arr, int sum, int n) {

        int[][] dp = new int[n + 1][sum + 1];

        // Initialization

        // If sum = 0 → one subset (empty set)
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        // If no elements and sum > 0 → 0 ways
        for (int j = 1; j <= sum; j++)
            dp[0][j] = 0;

        // Fill table
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {

                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]]  // include
                               + dp[i - 1][j];            // exclude
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {

        int[] arr = {2, 3, 5, 6, 8, 10};
        int sum = 10;
        int n = arr.length;

        System.out.println(countSubsets(arr, sum, n));
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
