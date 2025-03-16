/*
Print Longest Common Subsequence

You are given two strings s1 and s2.
Return the longest common subsequence of these strings.
If there’s no such string, return an empty string. If there are multiple possible answers, return any such string.

Note:
Longest common subsequence of string 's1' and 's2' is the longest subsequence of 's1' that is also a subsequence of 's2'. A ‘subsequence’ of 's1' is a string that can be formed by deleting one or more (possibly zero) characters from 's1'.


Example:
Input: 's1'  = "abcab", 's2' = "cbab"
Output: "bab"

Explanation:
"bab" is one valid longest subsequence present in both strings 's1' , 's2'.


Expected Answer:
"bba"

Explanation of sample output 1:
"bba" is only possible longest subsequence present in both s1 = "ababa" and s2 = "cbbcad". '1' is printed if the returned string is equal to "bba". 

Constraints:
1 <= n, m <= 10^3
*/

// T.C: O(n*m) 

public class PrintLCS {
    public static void longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n + 1][m + 1];

        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= m;j++){
                if(s1.charAt(i-1) == s2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } 
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); 
                }
            }
        }
        System.out.println("DP Table:");
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        int i = n,j= m;
        StringBuilder lcs = new StringBuilder();
        while(i>0 && j>0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                lcs.append(s1.charAt(i-1));
                i--;
                j--;  // move diagonally up-left
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                i--;
            }
            else{
                j--;
            }
        }
        System.out.println("LCS: " + lcs.reverse().toString());
    }
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "bdgek";
        longestCommonSubsequence(s1, s2);
    }
}
