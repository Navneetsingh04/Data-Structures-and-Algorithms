/*
Longest Common Substring

You are given two strings s1 and s2. Your task is to find the length of the longest common substring among the given strings.

Examples:
Input: s1 = "ABCDGH", s2 = "ACDGHR"
Output: 4
Explanation: The longest common substring is "CDGH" with a length of 4.

Input: s1 = "abc", s2 = "acb"
Output: 1
Explanation: The longest common substrings are "a", "b", "c" all having length 1.
Input: s1 = "YZ", s2 = "yz"
Output: 0

Constraints:
1 <= s1.size(), s2.size() <= 103
 
*/
public class LongestCommonSubstring {

    // Approach 1: Tabulation
    // T.C: O(n*m)
    // S.C: O(n*m)

    public static int longestCommonSubstr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[][]  = new int[n+1][m+1];
        int ans = 0;
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                    ans = Math.max(ans,dp[i][j]);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }

    // Approach 1: Space optimization
    // T.C: O(n*m)
    // S.C: O(n)

    public static int longestCommonSubstrI(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int prev[] = new int[m+1];
        int curr[] = new int[m+1];
        int ans = 0;
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    curr[j] = 1+prev[j-1];
                    ans = Math.max(ans,curr[j]);
                }
                else{
                    curr[j] = 0;
                }
            }
            prev = curr.clone();
        }
        return ans;
    }
    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "ACDGHR";
        System.out.println(longestCommonSubstr(s1, s2));
        System.out.println(longestCommonSubstrI(s1, s2));
    }
}
