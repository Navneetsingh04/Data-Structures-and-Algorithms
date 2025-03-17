/*
188. Best Time to Buy and Sell Stock IV

You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

Example 1:

Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.

Example 2:
Input: k = 2, prices = [3,2,6,5,0,3]
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 
Constraints:
1 <= k <= 100
1 <= prices.length <= 1000
0 <= prices[i] <= 1000 
*/

import java.util.Arrays;

public class BestTimeBuyAndSellStockIV {
    public static int maxProfit(int k,int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n][2][k+1];
        for(int matrix[][] : dp){
            for(int i[] : matrix){
                Arrays.fill(i,-1);
            }
        }
        return solve(0,1,k,prices,dp,n);
    }
    public static int solve(int i,int buy,int k,int prices[],int dp[][][],int n){
        if(i == n) return 0;
        if(k == 0) return 0;
        if(dp[i][buy][k] != -1){
            return dp[i][buy][k];
        }
        int profit = 0;
        if(buy==1){
            int take = -prices[i]+solve(i+1,0,k,prices,dp,n);
            int notTake = 0+solve(i+1,1,k,prices,dp,n);
            profit = Math.max(take,notTake);
        }
        else{
            int take = prices[i]+solve(i+1,1,k-1,prices,dp,n);
            int notTake = 0+solve(i+1,0,k,prices,dp,n);
            profit = Math.max(take,notTake);
        }
        return dp[i][buy][k] = profit;
    }

    // Approach 2: Tabulation

    public static int maxProfitI(int k,int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n+1][2][k+1];
        
        for(int i = 0;i<=n;i++){
            for(int j = 0;j<=1;j++){
                dp[i][j][0] = 0;
            }
        }
        for(int i = n-1;i>=0;i--){
            for(int j = 0;j<=1;j++){
                for(int l = 1;l<=k;l++){
                    if(j == 1){
                        int take = -prices[i]+ dp[i+1][0][l];
                        int notTake = 0+ dp[i+1][1][l];
                        dp[i][j][l] = Math.max(take,notTake);
                    }
                    else{
                        int take = prices[i]+dp[i+1][1][l-1];
                        int notTake = 0+dp[i+1][0][l];
                        dp[i][j][l] = Math.max(take,notTake);
                    }
                }
            }
        }
        return dp[0][1][k];
    }

    // Approach 3: Space Optimization

    public static int maxProfitII(int k,int[] prices) {
        int n = prices.length;
        int next[][] = new int[2][k+1]; 
        int curr[][] = new int[2][k+1]; 
    
        for(int i = n-1;i>=0;i--){
            for(int j = 0;j<=1;j++){
                for(int l = 1;l<=k;l++){
                    if(j == 1){
                        int take = -prices[i]+ next[0][l];
                        int notTake = 0+next[1][l];
                        curr[j][l] = Math.max(take,notTake);
                    }
                    else{
                        int take = prices[i]+next[1][l-1];
                        int notTake = next[0][l];
                        curr[j][l] = Math.max(take,notTake);
                    }
                }
            }
            next = curr.clone();
        }
        return next[1][k];
    }
    public static void main(String[] args) {
        int k = 2;
        int prices[] = {2,1,4,5,2,9,7};
        System.out.println(maxProfit(k, prices));
        System.out.println(maxProfitI(k, prices));
        System.out.println(maxProfitII(k, prices));
    }
}
