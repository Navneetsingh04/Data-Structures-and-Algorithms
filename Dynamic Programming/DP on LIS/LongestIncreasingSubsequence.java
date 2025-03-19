/*
L.C: 300. Longest Increasing Subsequence

Given an integer array nums, return the length of the longest strictly increasing subsequence.

Example 1:
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:
Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 
Constraints:
1 <= nums.length <= 2500
-104 <= nums[i] <= 104
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LongestIncreasingSubsequence {

    // Approach 1: Recurssion
    // T.C: O(2^n)
    // S.C: O(n)

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        return solve(0,-1,nums,n);
    }
    public static int solve(int i,int prevI,int nums[],int n){
        if(i == n){
            return 0;
        }
        int len = 0;
        len = solve(i+1,prevI,nums,n);
        if(prevI == -1 || nums[i] > nums[prevI]){
            len = Math.max(len,1+solve(i+1,i,nums,n));
        }
        return len;
    }

    // Approach 2: Memonization
    // T.C: O(n*n)
    // S.C: O(n)+(n*n)

    public static int lengthOfLISI(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n+1];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        return solveI(0,-1,nums,dp,n);
    }
    public static int solveI(int i,int prevI,int nums[],int dp[][],int n){
        if(i == n){
            return 0;
        }
        if(dp[i][prevI+1] != -1){
            return dp[i][prevI+1];
        }
        int len = 0;
        len = solveI(i+1,prevI,nums,dp,n);
        if(prevI == -1 || nums[i] > nums[prevI]){
            len = Math.max(len,1+solveI(i+1,i,nums,dp,n));
        }
        return dp[i][prevI+1] = len;
    }

    // Approach 3: Tabulation
    // T.C: O(n*n)
    // S.C: (n*n)

    public static int lengthOfLISII(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n+1][n+1];
        for(int i = n-1;i>=0;i--){
            for(int j = i-1;j>=-1;j--){
                dp[i][j+1] = dp[i+1][j+1];
                if(j == -1 || nums[i] > nums[j]){
                    dp[i][j+1] = Math.max(dp[i][j+1],1+dp[i+1][i+1]);
                }
            }
        }
        return dp[0][0];
    }

    // Approach 4: Space  Optimization
    // T.C: O(n*n)
    // S.C: (n*2)

    public static int lengthOfLISIII(int[] nums) {
        int n = nums.length;
        int prev[] = new int[n+1];
        int curr[] = new int[n+1];
        for(int i = n-1;i>=0;i--){
            for(int j = i-1;j>=-1;j--){
                curr[j+1] = prev[j+1];
                if(j == -1 || nums[i] > nums[j]){
                    curr[j+1] = Math.max(prev[j+1],1+prev[i+1]);
                }
            }
            prev = curr.clone();
        }
        return prev[0];
    }

    // Approach 4: Space Optimization (Optimally)
    // T.C: O(n*n)
    // S.C: (n)

    public static int lengthOfLISIV(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        int maxi = 1;
        for(int i = 0;i<n;i++){
            for(int prev = 0;prev<i;prev++){
                if(nums[prev] < nums[i]){ 
                    dp[i] = Math.max(dp[i],1+dp[prev]);
                }
            }
            maxi = Math.max(maxi,dp[i]);
        }
        return maxi;
    }

    // Approach 5: BInary Search and DP
    // T.C: O(nlogn)
    // S.C: (n)

    public static int lengthOfLISBS(int[] nums) {
        ArrayList<Integer> sub = new ArrayList<>();
        for(int num : nums) {
            int pos = Collections.binarySearch(sub, num);
            if(pos < 0) pos = -(pos + 1);
            if(pos == sub.size()) sub.add(num);
            else sub.set(pos, num);
        }
        return sub.size();
    }
    public static void main(String[] args) {
        int nums[] = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
        System.out.println(lengthOfLISI(nums));
        System.out.println(lengthOfLISII(nums));
        System.out.println(lengthOfLISIII(nums));
        System.out.println(lengthOfLISIV(nums));
        System.out.println(lengthOfLISBS(nums));
    }
}
