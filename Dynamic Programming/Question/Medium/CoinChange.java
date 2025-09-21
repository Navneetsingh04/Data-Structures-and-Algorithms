/*
L.C: 322. Coin Change

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.
Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1

Example 3:
Input: coins = [1], amount = 0
Output: 0
 
Constraints:
1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104 
*/
import java.util.Arrays;
public class CoinChange {
    public static int solveUsingMem(int[] coins, int amount,int dp[]){
        if(amount == 0) return 0;
        if(dp[amount] != -1) return dp[amount];
        int mini = Integer.MAX_VALUE;
        for(int i = 0;i<coins.length;i++){
            // Finding Answer using ith Coin
            if(amount - coins[i] >= 0){
                int recurrsionAns = solveUsingMem(coins,amount-coins[i],dp);
                if(recurrsionAns != Integer.MAX_VALUE){
                    int ans = 1+recurrsionAns;
                    mini = Math.min(mini,ans);
                }
            }
        }
        dp[amount] = mini;
        return dp[amount];
    }
    public static int solveUsingTab(int[] coins,int amount){
        int n = amount;
        int dp[] = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int value = 1;value<=amount;value++){
            int mini = Integer.MAX_VALUE;
            for(int i = 0;i<coins.length;i++){
                if(value - coins[i] >= 0){
                int recurrsionAns = dp[value-coins[i]];
                if(recurrsionAns != Integer.MAX_VALUE){
                    int ans = 1+recurrsionAns;
                    mini = Math.min(mini,ans);
                }
            }
        }
        dp[value] = mini;
    }
    return dp[amount];
    }
    public static int coinChange(int[] coins, int amount) {
        int n = amount;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        int ans = solveUsingTab(coins,amount);
        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int coins[] = {1,2,5};
        int amount = 11;
        int ans = coinChange(coins, amount);
        System.out.println("Minimum no of Coins Uesd: "+ans);
    }
}
 