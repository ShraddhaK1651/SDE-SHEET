Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:
Input: s = "axc", t = "ahbgdc"
Output: false

  //DO IT USING POINTERS O(N) DP IS NOT NECESSARY

class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();

        boolean[][] dp = new boolean[n+1][m+1];

        // Empty string is subsequence of any string
        for(int j = 0; j <= m; j++){
            dp[0][j] = true;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[n][m];
    }
}


        ""   a     h     b     g     d     c
      -----------------------------------------
""   |  T    T     T     T     T     T     T
a    |  F    T     T     T     T     T     T
b    |  F    F     F     T     T     T     T
c    |  F    F     F     F     F     F     T

Match → move diagonal
Not matched->move left
  
 We cannot use dp[i][j-1] && dp[i-1][j]
because subsequence allows deleting from t only,
not from s.

So dp[i-1][j] is logically invalid.
