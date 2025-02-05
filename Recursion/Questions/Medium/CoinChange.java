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
public class CoinChange {
    public static int solve(int coins[],int amount){
        if(amount == 0){
            return 0;
        }
        int mini = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<coins.length;i++){
            int coin = coins[i];
            if(coin <= amount){
                int recAns = solve(coins, amount-coin);
                if(recAns != Integer.MAX_VALUE){
                    ans = 1+recAns;
                }
            }
            mini = Math.min(mini,ans);
        }
        return mini;
    }
    public static int coinChange(int coins[],int amount){
        int ans = solve(coins, amount);
        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        else{
            return ans;
        }
    }
    public static void main(String[] args) {
        int coins[] = new int[]{1,2,5};
        int amount = 11;
        System.out.println("The fewest number of coins used is: "+coinChange(coins, amount));
    }
}
