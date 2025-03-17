/*
L.C: 309. Best Time to Buy and Sell Stock with Cooldown

You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

Example 1:
Input: prices = [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]

Example 2:
Input: prices = [1]
Output: 0

Constraints:
1 <= prices.length <= 5000
0 <= prices[i] <= 1000 
*/

import java.util.Arrays;

public class BuyAndSellStockWithCooldown {

    // Approach 1: Memonization

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n+1][2];
        for(int i[] :  dp){
            Arrays.fill(i,-1);
        }
        return solve(0,1,prices,dp,n);
    }
    public static int solve(int i,int buy,int prices[],int dp[][],int n){
        if(i >= n) return 0;
        int profit = 0;
        if(dp[i][buy] != -1){
            return dp[i][buy];
        }
        if(buy == 1){
            int take = -prices[i]+solve(i+1,0,prices,dp,n);
            int notTake = 0+solve(i+1,1,prices,dp,n);
            profit = Math.max(take,notTake);
        }
        else{
            int take = prices[i]+solve(i+2,1,prices,dp,n);
            int notTake = 0+solve(i+1,0,prices,dp,n);
            profit = Math.max(take,notTake);
        }
        return dp[i][buy] = profit;
    }

    // Approach 2: Tabulation

    public static int maxProfitI(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n+2][2];
        dp[n][0] = 0;
        dp[n][1] = 0;
        for(int i = n-1;i>=0;i--){
            for(int buy = 0;buy<=1;buy++){
                if(buy == 1){
                    dp[i][buy] = Math.max((-prices[i]+dp[i+1][0]),
                    0+dp[i+1][1]);
                }
                else{
                    dp[i][buy] = Math.max((prices[i]+dp[i+2][1]),
                    0+dp[i+1][0]);
                }
            }
        }
        return dp[0][1];
    }
    public static void main(String[] args) {
        int prices[] = {1,2,3,0,2};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfitI(prices));
    }
}
