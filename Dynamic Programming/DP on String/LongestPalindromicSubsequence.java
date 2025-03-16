/*
L.C: 516. Longest Palindromic Subsequence

Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

Example 1:
Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".

Example 2:
Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".

Constraints:
1 <= s.length <= 1000
s consists only of lowercase English letters. 
*/
public class LongestPalindromicSubsequence {
    public static int lcs(String s1,String s2){
        int n = s1.length();
        int m = s2.length();

        int dp[][] =  new int[n+1][m+1];
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 0+Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    public static int longestPalindromeSubseq(String s) {
        String s2 = new StringBuilder(s).reverse().toString();
        return lcs(s,s2);
    } 
    public static void main(String[] args) {
        String s = "bbabcbccab";
        System.out.println(longestPalindromeSubseq(s));
    }
}
