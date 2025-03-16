/*
L.C: 1143. Longest Common Subsequence

Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.

Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 
Constraints:
1 <= text1.length, text2.length <= 1000
text1 and text2 consist of only lowercase English characters. 
*/

import java.util.Arrays;

public class LongestCommonSubsequence {
    
    // Approach 1: Memonization
    // T.C: O(n * m)
    // S.C: O(n*m)+O(n+m)

     public static int solve(int index1,int index2,String s1, String s2,int dp[][]){
        if(index1 < 0 || index2 <0){
            return 0;
        }
        if(dp[index1][index2] != -1){
            return dp[index1][index2];
        }
        if(s1.charAt(index1) == s2.charAt(index2)){
            return 1+solve(index1-1,index2-1,s1,s2,dp);
        }
        dp[index1][index2] =  0+Math.max(solve(index1-1,index2,s1,s2,dp),solve(index1,index2-1,s1,s2,dp));
        return dp[index1][index2];
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n+1][m+1];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        return solve(n-1,m-1,text1,text2,dp);
    }

    // Approach 2: Tabulation
    // T.C: O(n * m)
    // S.C: O(n*m)

    public static int longestCommonSubsequenceI(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 0+Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    // Approach 3: Space Optimaztion
    // T.C: O(n * m)
    // S.C: O(m)
    

    public static int longestCommonSubsequenceII(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int prev[] = new int[m+1];
        int curr[] = new int[m+1];

        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    curr[j] = 1+prev[j-1];
                }
                else{
                    curr[j] = Math.max(prev[j],curr[j-1]);
                }
            }
            prev = curr.clone();
        }
        return prev[m];
    }
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));
        System.out.println(longestCommonSubsequenceI(text1, text2));
        System.out.println(longestCommonSubsequenceII(text1, text2));
    }
}
