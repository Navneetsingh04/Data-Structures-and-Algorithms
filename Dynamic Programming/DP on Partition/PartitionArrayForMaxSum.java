/*
L.C: 1043. Partition Array for Maximum Sum

Given an integer array arr, partition the array into (contiguous) subarrays of length at most k. After partitioning, each subarray has their values changed to become the maximum value of that subarray.

Return the largest sum of the given array after partitioning. Test cases are generated so that the answer fits in a 32-bit integer.

Example 1:
Input: arr = [1,15,7,9,2,5,10], k = 3
Output: 84
Explanation: arr becomes [15,15,15,9,10,10,10]

Example 2:
Input: arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
Output: 83

Example 3:
Input: arr = [1], k = 1
Output: 1

Constraints:
1 <= arr.length <= 500
0 <= arr[i] <= 109
1 <= k <= arr.length 
*/

import java.util.Arrays;

public class PartitionArrayForMaxSum {
    // Approach 1: Recursion
    // Time Complexity: O(2^n)
    // Space Complexity: O(n)
    public static int solve(int i,int arr[],int k,int n){
        if(i == n) return 0;
        int len = 0;
        int maxi = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;

        for(int j = i;j<Math.min(i+k,n);j++){
            len++;
            maxi = Math.max(maxi,arr[j]);
            int sum = (len*maxi)+solve(j+1,arr,k,n);
            maxAns = Math.max(sum,maxAns);
        }
        return maxAns;
    }
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        return solve(0,arr,k,n);
    }

    // Approach 2: Top Down DP(Recursion + Memoization)
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)+O(n) ~ O(n)

    public static int solveI(int i,int arr[],int k,int n,int dp[]){
        if(i == n) return 0;
        int len = 0;
        int maxi = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;
        if(dp[i] != -1){
            return dp[i];
        }
        for(int j = i;j<Math.min(i+k,n);j++){
            len++;
            maxi = Math.max(maxi,arr[j]);
            int sum = (len*maxi)+solveI(j+1,arr,k,n,dp);
            maxAns = Math.max(sum,maxAns);
        }
        return dp[i] = maxAns;
    }
    public static int maxSumAfterPartitioningI(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return solveI(0,arr,k,n,dp);
    }

    // Approach 3: Bottom Up DP(Tabulation)
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)

    public static int maxSumAfterPartitioningII(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n+1];
        dp[n] = 0;
        for(int i = n-1;i>=0;i--){
            int len = 0;
            int maxi = Integer.MIN_VALUE;
            int maxAns = Integer.MIN_VALUE;
            for(int j = i;j<Math.min(i+k,n);j++){
                len++;
                maxi = Math.max(maxi,arr[j]);
                int sum = (len*maxi)+dp[j+1];
                maxAns = Math.max(sum,maxAns);
            }
            dp[i] = maxAns;
        }
        return dp[0];
    }
    public static void main(String[] args) {
        int arr[] = {1,15,7,9,2,5,10};
        int k = 3;
        System.out.println(maxSumAfterPartitioning(arr,k));
        System.out.println(maxSumAfterPartitioningI(arr,k));
        System.out.println(maxSumAfterPartitioningII(arr,k));
    }
}
