/*
L.C: 132. Palindrome Partitioning II

Given a string s, partition s such that every substring of the partition is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of s.

Example 1:
Input: s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.

Example 2:
Input: s = "a"
Output: 0

Example 3:
Input: s = "ab"
Output: 1

Constraints:
1 <= s.length <= 2000
s consists of lowercase English letters only. 
*/

import java.util.Arrays;

public class PalindromePartitioningII {
    // Approach 1: Recursion
    // Time Complexity: O(2^n)
    // Space Complexity: O(n)

    public static boolean isPalindrome(String s){
        int n = s.length();
        int l = 0;
        int r = n-1;
        while(l<r){
            if(s.charAt(l++) != s.charAt(r--)){
                return false;
            }
        }
        return true;
    }
    public static int solve(int i,String s,int n){
        int minCost = Integer.MAX_VALUE;
        if(i == n){
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        for(int j = i;j<n;j++){
            sb.append(s.charAt(j));
            if(isPalindrome(sb.toString())){
                int cost = 1+solve(j+1,s,n);
                minCost = Math.min(minCost,cost);
            }
        }
        return minCost;
    }
    public static int minCut(String s) {
        int n = s.length();
        return solve(0,s,n)-1;
    }

    // Approach 2: Top Down DP(Recursion + Memoization)
    // Time Complexity: O(n^2)
    // Space Complexity: O(n^2)+O(n) ~ O(n^2)

    public static int solveI(int i,String s,int n,int dp[]){
        int minCost = Integer.MAX_VALUE;
        if(i == n){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        StringBuilder sb = new StringBuilder();
        for(int j = i;j<n;j++){
            sb.append(s.charAt(j));
            if(isPalindrome(sb.toString())){
                int cost = 1+solveI(j+1,s,n,dp);
                minCost = Math.min(minCost,cost);
            }
        }
        return dp[i] = minCost;
    }
    public static int minCutI(String s) {
        int n = s.length();
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return solveI(0,s,n,dp)-1;
    }

    // Approach 3: Bottom Up DP(Tabulation)
    // Time Complexity: O(n^2)
    // Space Complexity: O(n^2)

    public static int minCutII(String s) {
        int n = s.length();
        int dp[] = new int[n+1];
        dp[n] = 0;
        for(int i = n-1;i>=0;i--){
            StringBuilder sb = new StringBuilder();
            int minCost = Integer.MAX_VALUE;
            for(int j = i;j<n;j++){
                sb.append(s.charAt(j));
                if(isPalindrome(sb.toString())){
                    int cost = 1+dp[j+1];
                    minCost = Math.min(minCost,cost);
                }
            }
            dp[i] = minCost;
        }
        return dp[0]-1;
    }

    public static void main(String[] args) {
        String s = "bababcbadcede";
        System.out.println(minCut(s));
        System.out.println(minCutI(s));
        System.out.println(minCutII(s));
    }
}
