/*
L.C: 714. Best Time to Buy and Sell Stock with Transaction Fee

You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.

Note:
You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
The transaction fee is only charged once for each stock purchase and sale.
 
Example 1:
Input: prices = [1,3,2,8,4,9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
- Buying at prices[0] = 1
- Selling at prices[3] = 8
- Buying at prices[4] = 4
- Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.

Example 2:
Input: prices = [1,3,7,5,10,3], fee = 3
Output: 6
 
Constraints:
1 <= prices.length <= 5 * 104
1 <= prices[i] < 5 * 104
0 <= fee < 5 * 104 
*/

import java.util.Arrays;

public class BuyAndSellStocksWithTransectionFee {

    // Approach 1: Memonization

    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        return solve(0,1,prices,fee,dp,n);
    }
    public static int solve(int i,int buy,int prices[],int fee,int dp[][],int n){
        if(i >= n) return 0;
        if(dp[i][buy] != -1){
            return dp[i][buy];
        }
        int profit = 0;
        if(buy == 1){
            int take = -prices[i]+solve(i+1,0,prices,fee,dp,n);
            int notTake = 0+solve(i+1,1,prices,fee,dp,n);
            profit = Math.max(take,notTake);
        }
        else{
            int sellProfit = prices[i]-fee + solve(i+1,1,prices,fee,dp,n);
            int notSell = 0+solve(i+1,0,prices,fee,dp,n);
            profit = Math.max(sellProfit,notSell);
        }
        return dp[i][buy] = profit;
    }

    // Approach 2: Tabulation
    public static int maxProfitI(int[] prices, int fee) {
        int n = prices.length;
        int dp[][] = new int[n+1][2];
        dp[n][1] = 0;
        for(int i= n-1;i>=0;i--){
            for(int buy = 0;buy<=1;buy++){
                if(buy == 1){
                    int take = -prices[i]+ dp[i+1][0];
                    int notTake = 0+dp[i+1][1];
                    dp[i][buy] = Math.max(take,notTake);
                }
                else{
                    int sellProfit = prices[i]-fee + dp[i+1][1];
                    int notSell = 0+dp[i+1][0];
                    dp[i][buy] = Math.max(sellProfit,notSell);
                }
            }
        }
        return dp[0][1];
    }

    // Approach 3: Space Optimization

    public static int maxProfitII(int[] prices, int fee) {
        int n = prices.length;
        int prev[] = new int[2];
        int curr[] = new int[2];
        prev[0] = 0;
        prev[1] = 0;
        for(int i= n-1;i>=0;i--){
            for(int buy = 0;buy<=1;buy++){
                if(buy == 1){
                    int take = -prices[i]+ prev[0];
                    int notTake = prev[1];
                    curr[buy] = Math.max(take,notTake);
                }
                else{
                    int sellProfit = prices[i]-fee + prev[1];
                    int notSell = prev[0];
                    curr[buy] = Math.max(sellProfit,notSell);
                }
            }
            prev[0] = curr[0];
            prev[1] = curr[1];
        }
        return prev[1];
    }
    public static void main(String[] args) {
        int prices[] = {1,3,2,8,4,9};
        int fee = 2;
        System.out.println(maxProfit(prices, fee));
        System.out.println(maxProfitI(prices, fee));
        System.out.println(maxProfitII(prices, fee));
    }
}
