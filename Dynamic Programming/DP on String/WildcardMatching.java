/*
L.C: 44. Wildcard Matching

Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Example 1:
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:
Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.

Example 3:
Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 
Constraints:
0 <= s.length, p.length <= 2000
s contains only lowercase English letters.
p contains only lowercase English letters, '?' or '*'. 
*/
public class WildcardMatching {
    
    // Approach 1: Recurssion
    // T.C: O(exponentail)
    // S.C: O(n+m)

    public static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        return solve(n-1,m-1,s,p);
    }
    public static boolean solve(int i,int j,String s,String p){
        if(i<0 && j<0) return true;
        if(i>=0 && j<0) return false;
        if(i<0 && j>=0){
            for(int k = 0;k<=j;k++){
                if(p.charAt(k) != '*'){
                    return false;
                }
            }
            return true;
        }
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            return solve(i-1,j-1,s,p);
        }
        if(p.charAt(j) == '*'){
            return solve(i-1,j,s,p) || solve(i,j-1,s,p);
        }
        return false;
    }


    // Approach 2: Memonization
    // T.C: O(n*m)
    // S.C: O(n+m)+O(n*m)
    
    public static boolean isMatchI(String s, String p) {
        int n = s.length();
        int m = p.length();
        Boolean dp[][] = new Boolean[n+1][m+1];
        return solveI(n-1,m-1,s,p,dp);
    }
    public static boolean solveI(int i,int j,String s,String p,Boolean dp[][]){
        if(i<0 && j<0) return true;
        if(i>=0 && j<0) return false;
        if(i<0 && j>=0){
            for(int k = 0;k<=j;k++){
                if(p.charAt(k) != '*'){
                    return false;
                }
            }
            return true;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            return dp[i][j] = solveI(i-1,j-1,s,p,dp);
        }
        if(p.charAt(j) == '*'){
            return dp[i][j] = solveI(i-1,j,s,p,dp) || solveI(i,j-1,s,p,dp);
        }
        return dp[i][j] = false;
    }

    // Approach 3: Tabulation
    // T.C: O(n*m)
    // S.C: O(n+m)

    public static boolean isMatchII(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean dp[][] = new boolean[n+1][m+1];
        dp[0][0] = true;
        for(int i = 1;i<=n;i++){
            dp[i][0] = false;
        }
        for(int j = 1;j<=m;j++){
            boolean flag = true;
            for(int k = 1;k<=j;k++){
                if(p.charAt(k-1) != '*'){
                    flag = false;
                    break;
                }
            }
            dp[0][j] = flag;
        }
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
                else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s = "abcdef";
        String p = "ab*";
        System.out.println(isMatch(s, p));
        System.out.println(isMatchI(s, p));
        System.out.println(isMatchII(s, p));
    }
}