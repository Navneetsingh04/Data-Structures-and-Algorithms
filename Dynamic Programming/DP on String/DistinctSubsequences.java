/*
L.C: 115. Distinct Subsequences

Given two strings s and t, return the number of distinct subsequences of s which equals t.

The test cases are generated so that the answer fits on a 32-bit signed integer.


Example 1:
Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from s.
rabbbit
rabbbit
rabbbit

Example 2:
Input: s = "babgbag", t = "bag"
Output: 5
Explanation:
As shown below, there are 5 ways you can generate "bag" from s.
babgbag
babgbag
babgbag
babgbag
babgbag
 

Constraints:
1 <= s.length, t.length <= 1000
s and t consist of English letters. 
*/

import java.util.Arrays;

public class DistinctSubsequences {
    
    // Approach 1: Memonization
    // T.C: O(n*m)
    // S.C: O(n*m)+O(n+m)

    public static  int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int dp[][] = new int[n+1][m+1];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        return solve(n-1,m-1,s,t,dp);
    }
    public static int solve(int i,int j,String s,String t,int dp[][]){
        if(j<0) return 1;
        if(i<0) return 0;

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == t.charAt(j)){
            dp[i][j] = (solve(i-1,j-1,s,t,dp)+solve(i-1,j,s,t,dp));
        }
        else{
            dp[i][j] = solve(i-1,j,s,t,dp);
        }
        return dp[i][j];
    }

    // Approach 2: Tabulation
    // T.C: O(n*m)
    // S.C: O(n*m)

    public static int numDistinctI(String s, String t) {
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n+1][m+1];
        for(int i = 0;i<=n;i++) dp[i][0] = 1;
        for(int j = 1;j<=m;j++) dp[0][j] = 0;
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }

    // Approach 3: Space optimization
    // T.C: O(n*m)
    // S.C: O(m)

    public static int numDistinctII(String s, String t) {
        int n = s.length();
        int m = t.length();
        int prev[] = new int[m+1];
        int curr[] = new int[m+1];

        prev[0] = 1;
        for(int i = 1;i<=n;i++){
            curr[0] = 1;
            for(int j = 1;j<=m;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    curr[j] = prev[j-1]+prev[j]; //include+exclude
                }
                else{
                   curr[j] = prev[j]; //exclude only
                }
            }
            prev = curr.clone();
        }
        return prev[m];
    }
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(numDistinct(s, t));
        System.out.println(numDistinctI(s, t));
        System.out.println(numDistinctII(s, t));
    }
}
