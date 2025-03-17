/*
L.C: 123. Best Time to Buy and Sell Stock III

You are given an array prices where prices[i] is the price of a given stock on the ith day.
Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

Example 1:
Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.

Example 2:
Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.

Example 3:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 
Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 105 
*/

import java.util.Arrays;

public class BestTimeBuyAndSellStockIII {

    // Approach 1: Memonization
    // T.C: O(n*2*3)
    // S.C: O(n)+O(2n)

     public static int maxProfit(int[] prices) {
        int n = prices.length;
        int cap = 2;
        int dp[][][] = new int[n][2][cap+1];
        for(int i[][] : dp){
            for(int row[] : i){
                Arrays.fill(row,-1);
            }
        }
        return solve(0,1,cap,prices,dp,n);
    }
    public static int solve(int i,int buy,int cap,int prices[],int dp[][][],int n){
        if(i == n) return 0;
        if(cap == 0) return 0;
        if(dp[i][buy][cap] != -1){
            return dp[i][buy][cap];
        }
        int profit = 0;
        if(buy==1){
            int take = -prices[i]+solve(i+1,0,cap,prices,dp,n);
            int notTake = 0+solve(i+1,1,cap,prices,dp,n);
            profit = Math.max(take,notTake);
        }
        else{
            int take = prices[i]+solve(i+1,1,cap-1,prices,dp,n);
            int notTake = 0+solve(i+1,0,cap,prices,dp,n);
            profit = Math.max(take,notTake);
        }
        return dp[i][buy][cap] = profit;
    }

    // Approach 2: Tabulation
    // T.C: O(2n)
    // S.C: O(n)+O(2n)

    public static int maxProfitI(int[] prices) {
        int n = prices.length;
        int cap = 2;
        int dp[][][] = new int[n+1][2][cap+1];
        
        for(int i = 0;i<=n;i++){
            for(int j = 0;j<=1;j++){
                dp[i][j][0] = 0;
            }
        }
        for(int i = n-1;i>=0;i--){
            for(int j = 0;j<=1;j++){
                for(int k = 1;k<=cap;k++){
                    if(j == 1){
                        int take = -prices[i]+ dp[i+1][0][k];
                        int notTake = 0+ dp[i+1][1][k];
                        dp[i][j][k] = Math.max(take,notTake);
                    }
                    else{
                        int take = prices[i]+dp[i+1][1][k-1];
                        int notTake = 0+dp[i+1][0][k];
                        dp[i][j][k] = Math.max(take,notTake);
                    }
                }
            }
        }
        return dp[0][1][cap];
    }

    // Approach 3: space optimization 
    // T.C: O(2*n)
    // S.C: O(6)

    public static int maxProfitII(int[] prices) {
        int n = prices.length;
        int cap = 2;
        int next[][] = new int[2][cap+1]; //stores dp[i+1]
        int curr[][] = new int[2][cap+1]; //stores dp[i]
    
        for(int i = n-1;i>=0;i--){
            for(int j = 0;j<=1;j++){
                for(int k = 1;k<=cap;k++){
                    if(j == 1){
                        int take = -prices[i]+ next[0][k];
                        int notTake = 0+next[1][k];
                        curr[j][k] = Math.max(take,notTake);
                    }
                    else{
                        int take = prices[i]+next[1][k-1];
                        int notTake = next[0][k];
                        curr[j][k] = Math.max(take,notTake);
                    }
                }
            }
            next = curr.clone();
        }
        return next[1][cap];
    }
    public static void main(String[] args) {
        int prices[] = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfitI(prices));
        System.out.println(maxProfitII(prices));
    }
}
