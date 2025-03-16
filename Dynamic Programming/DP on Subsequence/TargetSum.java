/*
L.C: 494. Target Sum

You are given an integer array nums and an integer target.
You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.

Example 1:
Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3

Example 2:
Input: nums = [1], target = 1
Output: 1

Constraints:
1 <= nums.length <= 20
0 <= nums[i] <= 1000
0 <= sum(nums[i]) <= 1000
-1000 <= target <= 1000 
*/

import java.util.Arrays;

public class TargetSum{
    // Approach 1: brute force
    // Time Complexity: O(2^n)

    // public int findTargetSumWays(int[] nums, int target) {
    //     return countWays(nums,0,target);
    // }
    // public int countWays(int nums[],int index,int target){
    //     if(index == nums.length){
    //         return target == 0 ? 1:0;
    //     }
    //     int add = countWays(nums,index+1,target-nums[index]);
    //     int subtract = countWays(nums,index+1,target+nums[index]);
    //     return add+subtract;
    // }

    // Approach 2: using Memonization
    // Time Complexity: O(2*totalsum)

    public static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if(Math.abs(target) > sum) return 0;
        int dp[][] = new int[n+1][2*sum+1];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        return countWays(nums,0,target,dp,n,sum);
    }
    public static int countWays(int nums[],int index,int target,int dp[][],int n,int sum){
        if(index == n){
            return target == 0 ? 1:0;
        }
        int newTarget = target+sum;
        if(newTarget < 0 || newTarget > 2*sum) return 0;
        if(dp[index][newTarget] != -1){
            return dp[index][newTarget];
        }
        int add = countWays(nums,index+1,target-nums[index],dp,n,sum);
        int subtract = countWays(nums,index+1,target+nums[index],dp,n,sum);
        return dp[index][newTarget] = add+subtract;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,3,1};
        int target = 3;
        System.out.println(findTargetSumWays(nums, target));
    }
}