/*
L.C: 1547. Minimum Cost to Cut a Stick

Given a wooden stick of length n units. The stick is labelled from 0 to n. For example, a stick of length 6 is labelled as follows:

Given an integer array cuts where cuts[i] denotes a position you should perform a cut at.
You should perform the cuts in order, you can change the order of the cuts as you wish.

The cost of one cut is the length of the stick to be cut, the total cost is the sum of costs of all cuts. When you cut a stick, it will be split into two smaller sticks (i.e. the sum of their lengths is the length of the stick before the cut). Please refer to the first example for a better explanation.

Return the minimum total cost of the cuts.

Example 1:

Input: n = 7, cuts = [1,3,4,5]
Output: 16
Explanation: Using cuts order = [1, 3, 4, 5] as in the input leads to the following scenario:

The first cut is done to a rod of length 7 so the cost is 7. The second cut is done to a rod of length 6 (i.e. the second part of the first cut), the third is done to a rod of length 4 and the last cut is to a rod of length 3. The total cost is 7 + 6 + 4 + 3 = 20.
Rearranging the cuts to be [3, 5, 1, 4] for example will lead to a scenario with total cost = 16 (as shown in the example photo 7 + 4 + 3 + 2 = 16).
Example 2:

Input: n = 9, cuts = [5,6,1,4,2]
Output: 22
Explanation: If you try the given cuts ordering the cost will be 25.
There are much ordering with total cost <= 25, for example, the order [4, 6, 5, 2, 1] has total cost = 22 which is the minimum possible.
 
Constraints:
2 <= n <= 106
1 <= cuts.length <= min(n - 1, 100)
1 <= cuts[i] <= n - 1
All the integers in cuts array are distinct. 
*/

import java.util.Arrays;

public class MinimumCostToCutStick {
    
    // Approach 1: Recursion
    // Time Complexity: O(2^n)
    // Space Complexity: O(n)

    public int func(int i ,int j,int cuts[]){
        int mini = Integer.MAX_VALUE;
        if(i>j) return 0;
        for(int idx = i;idx<=j;idx++){
            int cost = (cuts[j+1] - cuts[i-1])+func(i,idx-1,cuts)+func(idx+1,j,cuts);
            mini = Math.min(mini,cost);
        }
        return mini;
    }
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int newCuts[] = new int[m+2];
        newCuts[0] = 0;
        newCuts[m+1] = n;

        for(int i = 0;i<m;i++){
            newCuts[i+1] = cuts[i];
        }
        Arrays.sort(newCuts);
        return func(1,m,newCuts);
    }

    // Approach 2: Top Down DP(Recursion + Memoization)
    // Time Complexity: O(n^3)
    // Space Complexity: O(n^2)+O(n) ~ O(n^2)

    public int funcI(int i ,int j,int cuts[],int dp[][]){
        int mini = Integer.MAX_VALUE;
        if(i>j) return 0;
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        for(int idx = i;idx<=j;idx++){
            int cost = (cuts[j+1] - cuts[i-1])+
            funcI(i,idx-1,cuts,dp)+funcI(idx+1,j,cuts,dp);
            mini = Math.min(mini,cost);
        }
        return dp[i][j] = mini;
    }
    public int minCostI(int n, int[] cuts) {
        int m = cuts.length;
        int newCuts[] = new int[m+2];
        newCuts[0] = 0;
        newCuts[m+1] = n;

        for(int i = 0;i<m;i++){
            newCuts[i+1] = cuts[i];
        }
        Arrays.sort(newCuts);
        int dp[][] = new int[m+2][m+2];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        return funcI(1,m,newCuts,dp);
    }

    // Approach 3: Bottom Up DP(Tabulation)
    // Time Complexity: O(n^3)
    // Space Complexity: O(n^2)

    public int minCostII(int n, int[] cuts) {
        int m = cuts.length;
        int newCuts[] = new int[m+2];
        newCuts[0] = 0;
        newCuts[m+1] = n;  

        for(int i = 0;i<m;i++){
            newCuts[i+1] = cuts[i];
        }
        Arrays.sort(newCuts);
        int dp[][] = new int[m+2][m+2];
        for(int i = m;i>=1;i--){
            for(int j = 1;j<=m;j++){
                if(i>j) continue;
                int mini = Integer.MAX_VALUE;
                for(int idx = i;idx<=j;idx++){
                    int cost = (newCuts[j+1]-newCuts[i-1])+
                    dp[i][idx-1] +dp[idx+1][j];
                    mini = Math.min(mini,cost);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][m];
    }
    public static void main(String[] args) {
        int n = 7;
        int cuts[] = {1,3,4,5};
        System.out.println(new MinimumCostToCutStick().minCost(n,cuts));
        System.out.println(new MinimumCostToCutStick().minCostI(n,cuts));
        System.out.println(new MinimumCostToCutStick().minCostII(n,cuts));
    }   
}
