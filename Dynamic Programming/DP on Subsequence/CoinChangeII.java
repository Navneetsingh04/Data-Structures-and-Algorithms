/*
L.C: 518. Coin Change II

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
You may assume that you have an infinite number of each kind of coin.
The answer is guaranteed to fit into a signed 32-bit integer.

Example 1:
Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1

Example 2:
Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.

Example 3:
Input: amount = 10, coins = [10]
Output: 1

Constraints:
1 <= coins.length <= 300
1 <= coins[i] <= 5000
All the values of coins are unique.
0 <= amount <= 5000 
*/

import java.util.Arrays;

public class CoinChangeII {
    // Approach 1: Brute force
    // Time COmplexity: O(2^n)
    // Space Complexity: O(n)

    public static int change(int amount, int[] coins) {
        int n = coins.length;
        return solve(n-1,amount,coins);
    }
    public static int solve(int index,int amount,int coins[]){
        if(index == 0){
            return (amount % coins[0]) == 0 ? 1: 0;
        }
        int notTake = solve(index-1,amount,coins);
        int take = 0;
        if(coins[index] <= amount){
            take = solve(index,amount-coins[index],coins);
        } 
        return take+notTake;
    }

    // Approach 2: Memonization
    // Time COmplexity: O(n*amount)
    // Space Complexity: O(n)

    public static int changeI(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n+1][amount+1];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        } 
        return solve(n-1,amount,coins,dp);
    }
    public static int solve(int index,int amount,int coins[],int dp[][]){
        if(index == 0){
            return (amount % coins[0]) == 0 ? 1: 0;
        }
        if(dp[index][amount] != -1){
            return dp[index][amount];
        }
        int notTake = solve(index-1,amount,coins,dp);
        int take = 0;
        if(coins[index] <= amount){
            take = solve(index,amount-coins[index],coins,dp);
        } 
        return dp[index][amount] = take+notTake;
    }

    public static void main(String[] args) {
        int amount = 5;
        int coins[] = {1,2,5};
        System.out.println(change(amount, coins));
        System.out.println(changeI(amount, coins));
    }
}
