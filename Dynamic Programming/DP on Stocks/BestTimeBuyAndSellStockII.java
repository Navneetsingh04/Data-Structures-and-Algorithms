/*
L.C: 122. Best Time to Buy and Sell Stock II

You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
Find and return the maximum profit you can achieve.

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.

Example 2:
Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.

Example 3:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 
Constraints:
1 <= prices.length <= 3 * 104
0 <= prices[i] <= 104 
*/

import java.util.Arrays;

public class BestTimeBuyAndSellStockII {
    
    // Approach 1: Memonization
    // T.C: O(2n)
    // S.C: O(n)+O(2n)

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n+1][2];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        return solve(0,1, prices,dp,n);
    }
    public static int solve(int i,int buy,int[] prices,int dp[][],int n){
        if(i == n) return 0;
        if(dp[i][buy] != -1){
            return dp[i][buy];
        }
        int profit = 0;
        if(buy == 1){
            int take = -prices[i]+solve(i+1,0,prices,dp,n);
            int notTake = 0+solve(i+1,1, prices,dp,n);
            profit = Math.max(take,notTake);
        }
        else{
            int take = prices[i]+solve(i+1,1, prices,dp,n);
            int notTake = 0+solve(i+1,0, prices,dp,n);
            profit = Math.max(take,notTake);
        }
        return dp[i][buy] = profit;
    }

    // Approach 2: Tabulation
    // T.C: O(2n)
    // S.C: O(n)

    public static int maxProfitI(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n+1][2];
        dp[n][0] = 0;
        for(int i = n-1;i>=0;i--){
            for(int j = 0;j<=1;j++){
                if(j == 1){
                    int take = -prices[i]+ dp[i+1][0];
                    int notTake = 0+ dp[i+1][1];
                    dp[i][j] = Math.max(take,notTake);
                }
                else{
                    int take = prices[i]+ dp[i+1][1];
                    int notTake = 0+dp[i+1][0];
                    dp[i][j] = Math.max(take,notTake);
                }
            }
        }
        return dp[0][1];
    }

    // Approach 3: Space optimization 
    // T.C: O(n)
    // S.C: O(4)

    public static int maxProfitII(int[] prices) {
        int n = prices.length;
        int ahead[] = new int[2];
        int curr[] = new int[2];
        ahead[0] = 0;
        for(int i = n-1;i>=0;i--){
            for(int j = 0;j<=1;j++){
                if(j == 1){
                    int take = -prices[i]+ ahead[0];
                    int notTake = 0+ ahead[1];
                    curr[j] = Math.max(take,notTake);
                }
                else{
                    int take = prices[i]+ ahead[1];
                    int notTake = 0+ahead[0];
                    curr[j] = Math.max(take,notTake);
                }
            }
            ahead = curr.clone();
        }
        return ahead[1];
    }
    public static void main(String[] args) {
        int prices[] = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfitI(prices));
        System.out.println(maxProfitII(prices));

    }
}
