/*
Rod Cutting

Given a rod of length n inches and an array price[]. price[i] denotes the value of a piece of length i. The task is to determine the maximum value obtainable by cutting up the rod and selling the pieces.

Note: price[] is 1-indexed array.

Input: price[] =  [1, 5, 8, 9, 10, 17, 17, 20]
Output: 22
Explanation:  The maximum obtainable value is 22 by cutting in two pieces of lengths 2 and 6, i.e., 5 + 17 = 22.

Input : price[] =  [3, 5, 8, 9, 10, 17, 17, 20]
Output : 24
Explanation : The maximum obtainable value is 24 by cutting the rod into 8 pieces of length 1, i.e, 8*price[1]= 8*3 = 24.

Input : price[] =  [3]
Output : 3
Explanation: There is only 1 way to pick a piece of length 1. 
*/

import java.util.Arrays;

public class RodCutting {
    // Approach 1: Brute Force
    // T.C: O(2^n)
    // S.C: O(N)
    public static int solve(int index,int price[],int n){
        if(index == 0){
            return n*price[0];
        }
        int notTake = solve(index-1,price,n);
        int take = 0;
        int rodLength = index+1;
        if(rodLength <= n){
            take = price[index]+solve(index,price,n-rodLength);
        }
        return Math.max(take, notTake);
    }
    public static int cutRod(int prices[],int n){
        return solve(n-1,prices,n);
    }

    // Approach 2: Memonization
    // T.C: O(n^2)
    // S.C: O(n^2)+O(N)

     public static int solveI(int index, int price[], int n, int[][] dp) {
        if (index == 0) {
            return n * price[0];
        }
        if (dp[index][n] != -1) return dp[index][n];
        int notTake = solveI(index - 1, price, n, dp);
        int take = 0;
        int rodLength = index + 1;
        if (rodLength <= n) {
            take = price[index] + solveI(index, price, n - rodLength, dp);
        }
        return dp[index][n] = Math.max(take, notTake);
    }

    public static int cutRodI(int prices[], int n) {
        int[][] dp = new int[prices.length][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return solveI(prices.length - 1, prices, n, dp);
    }

    // Approach 3: Tabulation (bottom-up DP) 
    // T.C: O(n^2)
    // S.C: O(n^2)

    public static int cutRodII(int prices[], int n) {
        int[][] dp = new int[prices.length][n + 1];
        for(int rodLength = 0;rodLength <= n;rodLength++) {
            dp[0][rodLength] = rodLength*prices[0];
        }
        for(int index = 1;index<prices.length;index++) {
            for(int rodLength = 0; rodLength <= n; rodLength++) {
                int notTake = dp[index-1][rodLength];
                int take = 0;
                int currentRodLength = index + 1;
                if(currentRodLength <= rodLength) {
                    take = prices[index] + dp[index][rodLength - currentRodLength];
                }
                dp[index][rodLength] = Math.max(take, notTake);
            }
        }
        return dp[prices.length - 1][n];
    }

    // Approach 4: Space optimzation
    // T.C: O(n^2)
    // S.C: O(n)

    public static int cutRodIII(int prices[], int n){
        int prev[] = new int[n+1];
        for(int i = 0;i<=n;i++){
            prev[i] = i*prices[0];
        }
        for(int i = 1;i<prices.length;i++){
            int curr[] = new int[n+1];
            for(int rodLength = 0;rodLength<=n;rodLength++){
                int notTake = prev[rodLength];
                int take = 0;
                int currLen = i+1;
                if(currLen <= rodLength){
                    take = prices[i]+curr[rodLength-currLen];
                }
                curr[rodLength] = Math.max(take,notTake);
            }
            prev = curr;
        }
        return prev[n];
    }
    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        int n = price.length;
        System.out.println(cutRod(price, n));
        System.out.println(cutRodI(price, n));
        System.out.println(cutRodII(price, n));
        System.out.println(cutRodII(price, n));
    }
}