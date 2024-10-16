/*
L.C: 416. Partition Equal Subset Sum

Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

Example 1:
Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:
Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 
Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100
*/

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public static boolean subsetSum(int index,int n,int target,int nums[],int dp[][]){
        if(target == 0) return true;
        if(index == 0) return (nums[0] == target);
        if(dp[index][target] != -1){
            return dp[index][target] == 1;
        }
        boolean notTake = subsetSum(index-1,n,target,nums,dp);
        boolean take = false;
        if(nums[index] <= target){
            take = subsetSum(index-1,n,target-nums[index],nums,dp);
        }
        dp[index][target] = notTake || take?1:0;
        return dp[index][target] == 1;
    }
    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
       
        for(int i: nums){
            totalSum += i;
        }
        if(totalSum%2 != 0) return false;
        int target = totalSum/2;
        int dp[][] = new int[n][target+1];
        for(int i[]: dp){
            Arrays.fill(i,-1);
        }
        return subsetSum(n-1,n,target,nums,dp);
    }
    public static void main(String[] args) {
        int nums[] = {2,3,3,3,4,5};
        System.out.println(canPartition(nums));
    }
}
