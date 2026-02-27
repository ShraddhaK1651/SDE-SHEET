// User function Template for Java
import java.util.*;
class Solution {
    public String common_String(String s1, String s2) {
        // code here
        int n=s1.length();
        int m=s2.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
            StringBuilder lcs=new StringBuilder();
            int i=n;
            int j=m;
            while(i>0 && j>0){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    lcs.append(s1.charAt(i-1));
                    i--;
                    j--;
                }
                else if(dp[i-1][j]>dp[i][j-1]){
                    i--;
                }
                else{
                    j--;
                }
            }
            lcs.reverse();
            
            Set<Character>hs=new HashSet<>();
            StringBuilder res=new StringBuilder();
            for(char ch : lcs.toString().toCharArray()){
                if(!hs.contains(ch)){
                    res.append(ch);
                    hs.add(ch);
                }
            }
            return res.toString();
        
}    }
