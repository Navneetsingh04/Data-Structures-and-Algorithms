/*
L.C: 72. Edit Distance

Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 
Example 1:
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

Example 2:
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 
Constraints:
0 <= word1.length, word2.length <= 500
word1 and word2 consist of lowercase English letters. 
*/

import java.util.Arrays;

public class EditDistance {

    // Approach 1: Memonization
    // T.C: O(n*m)
    // S.C: O(n*m)+O(n+m)

      public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] =  new int[n+1][m+1];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        return solve(n-1,m-1,word1,word2,dp);
    }
    public static int solve(int i,int j,String word1, String word2,int dp[][]){
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(word1.charAt(i) == word2.charAt(j)){
            dp[i][j] =  solve(i-1,j-1,word1,word2,dp);
        }
        else{
            int insert = 1+solve(i,j-1,word1,word2,dp);
            int delete = 1+solve(i-1,j,word1,word2,dp);
            int replace = 1+solve(i-1,j-1,word1,word2,dp);

            dp[i][j] =  Math.min(insert,Math.min(delete,replace));
        }
        return dp[i][j];
    }

    // Approach 2: Tabulation
    // T.C: O(n*m)
    // S.C: O(n*m)

    public static int minDistanceI(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] =  new int[n+1][m+1];
        for(int i = 0;i<=n;i++) dp[i][0] = i;
        for(int j = 0;j<=m;j++) dp[0][j] = j;

        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] =  1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                }
            }
        }
        return dp[n][m];
    }

    // Approach 3: Space Optimzation
    // T.C: O(n*m)
    // S.C: O(m)

    public static int minDistanceII(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int prev[] = new int[m+1];
        int curr[] = new int[m+1];
        for(int j = 0;j<=m;j++) prev[j] = j;

        for(int i = 1;i<=n;i++){
            curr[0] = i;
            for(int j = 1;j<=m;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    curr[j] = prev[j-1];
                }
                else{
                    int insert = 1 + curr[j-1];
                    int delete = 1 + prev[j];
                    int replace = 1 + prev[j-1];
                    curr[j] = Math.min(insert,Math.min(delete,replace));
                }
            }
            prev = curr.clone();
        }
        return prev[m];
    }
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistance(word1,word2));
        System.out.println(minDistanceI(word1,word2));
        System.out.println(minDistanceII(word1,word2));
    }
}
