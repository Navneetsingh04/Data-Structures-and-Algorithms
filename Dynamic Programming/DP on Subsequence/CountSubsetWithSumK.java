/*
naukri: 

You are given an array 'arr' of size 'n' containing positive integers and a target sum 'k'.
Find the number of ways of selecting the elements from the array such that the sum of chosen elements is equal to the target 'k'.
Since the number of ways can be very large, print it modulo 10 ^ 9 + 7.

Sample Input 1 :
4 5
1 4 4 5
Sample Output 1 :
3
Explanation For Sample Output 1:
The possible ways are:
[1, 4]
[1, 4]
[5]
Hence the output will be 3. Please note that both 1 present in 'arr' are treated differently.

Sample Input 2 :
3 2
1 1 1
Sample Output 2 :
3
Explanation For Sample Output 1:
There are three 1 present in the array. Answer is the number of ways to choose any two of them.
Constraints:
1 <= 'n' <= 100
0 <= 'arr[i]' <= 1000
1 <= 'k' <= 1000

*/

import java.util.Arrays;

public class CountSubsetWithSumK {
    static int mod = (int) 1e9 + 7;
    public static int solve(int index, int num[], int tar, int dp[][]) {
        if(tar == 0){
            return 1;
        }
        if(index == 0){
            return (num[0] == tar) ? 1 : 0; 
        }
        if(dp[index][tar] != -1){
            return dp[index][tar];
        }
        int notTake = solve(index - 1, num, tar, dp) % mod; 
        int take = 0;
        if(num[index] <= tar){ 
            take = solve(index - 1, num, tar - num[index], dp) % mod; 
        }
        dp[index][tar] = (take + notTake) % mod;
        return dp[index][tar];
    }
    public static int findWays(int num[], int tar) {
        int n = num.length;
        if (n == 0) {
            return (tar == 0) ? 1 : 0; 
        }
        int dp[][] = new int[n][tar + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(n - 1, num, tar, dp);
    }
    // Tabulation Approach
    public static int Tabulation(int num[], int tar) {
        int n = num.length;
        if (n == 0) {
            return (tar == 0) ? 1 : 0;
        }

        int[][] dp = new int[n][tar + 1];
        dp[0][0] = 1;

        if (num[0] == 0) {
            dp[0][0] = 2;
        }

        if (num[0] != 0 && num[0] <= tar) {
            dp[0][num[0]] = 1;
        }

        for (int index = 1; index < n; index++) {
            for (int target = 0; target <= tar; target++) {
                int notTake = dp[index - 1][target] % mod;
                int take = 0;
                if (num[index] <= target) {
                    take = dp[index - 1][target - num[index]] % mod;
                }
                dp[index][target] = (take + notTake) % mod;
            }
        }

        return dp[n - 1][tar];
    }
    public static void main(String[] args) {
        int num[] = {1,4,4,5};
        int target =  5;
        System.out.println(findWays(num,target));
        // System.out.println(Tabulation(num,target));
    }
}
