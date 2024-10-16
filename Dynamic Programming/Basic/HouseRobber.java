/*
L.c: 198. House Robber

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 2:
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 
Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 400 
*/

import java.util.Arrays;
public class HouseRobber {
    // Using Memonization: top-down Approach
    public static int solve(int arr[],int index,int dp[]){
        if(index >= arr.length){
            return 0;
        }
        if(dp[index] != -1) return dp[index];
        int include = arr[index]+solve(arr,index+2,dp);
        int exclude = 0+solve(arr, index+1, dp);
        dp[index] = Math.max(include, exclude);
        return dp[index];
    }
    // Using Tabulation(Bottom-up Approach)
    public static int solveUsingTab(int arr[]){
        int n = arr.length;
        int dp[] =  new int[n+1];
        Arrays.fill(dp,-1);
        dp[n-1] = arr[n-1];
        for(int index = n-2;index>=0;index--){
            int tempAns = 0;
            if(index+2<n){
                tempAns = dp[index+2];
            }
            int include = arr[index]+tempAns;
            int exclude = 0+dp[index+1];
            dp[index] = Math.max(include,exclude);
        }
        return dp[0];
    }
    // Space Optimazation
    public static int solveUsingTabSO(int arr[]){
        int n = arr.length;
        int prev = arr[n-1];
        int next = 0;
        int curr;
        for(int index = n-2;index>=0;index--){
            int tempAns = 0;
            if(index+2<n){
                tempAns = next;
            }
            int include = arr[index]+tempAns;
            int exclude = 0+prev;
            curr = Math.max(include,exclude);
            next = prev;
            prev = curr;
        }
        return prev;
    }
    public static int rob(int arr[]){
        int index = 0;
        int n = arr.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        int ans = solve(arr,index,dp);
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {2,7,9,3,1};
        System.out.println("Total amount robbed using Memonization: "+rob(arr));
        System.out.println("Total amount robbed using Tabulation: "+solveUsingTab(arr));
        System.out.println("Total amount robbed Space Optization: "+solveUsingTabSO(arr));
    }
}