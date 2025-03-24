/*
L.C: 312. Burst Balloons

You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.

If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.

Return the maximum coins you can collect by bursting the balloons wisely.

Example 1:
Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167

Example 2:
Input: nums = [1,5]
Output: 10
 
Constraints:
n == nums.length
1 <= n <= 300
0 <= nums[i] <= 100 
*/
import java.util.Arrays;

public class BrustBallon{
    // Approach 1: Recursion
    // Time Complexity: O(2^n)
    // Space Complexity: O(n)

    public static int solve(int i,int j,int arr[]){
        if(i>j) return 0;
        int maxi = Integer.MIN_VALUE;
        for(int idx = i;idx<=j;idx++){
            int cost = arr[i-1]*arr[idx]*arr[j+1]+
            solve(i,idx-1,arr)+solve(idx+1,j,arr);
            maxi = Math.max(maxi,cost);
        }
        return maxi;
    }
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n+2];
        arr[0] = 1;
        arr[n+1] = 1;
        for(int i = 0;i<n;i++){
            arr[i+1] = nums[i];
        }
        return solve(1,n,arr);
    }

    // Approach 2: Top Down DP(Recursion + Memoization)
    // Time Complexity: O(n^3)
    // Space Complexity: O(n^2)+O(n) ~ O(n^2)

    public static int solveI(int i,int j,int arr[],int dp[][]){
        if(i>j) return 0;
        int maxi = Integer.MIN_VALUE;
        if(dp[i][j] != -1) return dp[i][j];
        for(int idx = i;idx<=j;idx++){
            int cost = arr[i-1]*arr[idx]*arr[j+1]+
            solveI(i,idx-1,arr,dp)+solveI(idx+1,j,arr,dp);
            maxi = Math.max(maxi,cost);
        }
        return dp[i][j] = maxi;
    }
    public static int maxCoinsI(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n+2];
        arr[0] = 1;
        arr[n+1] = 1;
        for(int i = 0;i<n;i++){
            arr[i+1] = nums[i];
        }
        int dp[][] = new int[n+2][n+2];
        for(int i[]: dp){
            Arrays.fill(i,-1);
        }
        return solveI(1,n,arr,dp);
    }

    // Approach 3: Bottom Up DP(Tabulation)
    // Time Complexity: O(n^3)
    // Space Complexity: O(n^2)

    public static int maxCoinsII(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n+2];
        arr[0] = 1;
        arr[n+1] = 1;
        for(int i = 0;i<n;i++){
            arr[i+1] = nums[i];
        }
        int dp[][] = new int[n+2][n+2];
        for(int i = n;i>=1;i--){
            int maxi = Integer.MIN_VALUE;
            for(int j = 1;j<=n;j++){
                if(i>j) continue;
                for(int idx = i;idx<=j;idx++){
                    int cost = arr[i-1]*arr[idx]*arr[j+1]+
                    dp[i][idx-1]+dp[idx+1][j];
                    maxi = Math.max(maxi,cost);
                }
                dp[i][j] = maxi;
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        int arr[] = {3,1,5,8};
        System.out.println(maxCoins(arr));
        System.out.println(maxCoinsI(arr));
        System.out.println(maxCoinsII(arr));
    }
}