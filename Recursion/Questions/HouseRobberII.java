/*
L.C: 213. House Robber II

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 3:

Input: nums = [1,2,3]
Output: 3
 
Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 1000
 */
public class HouseRobberII {
    public static int solve(int arr[],int s,int e){
        if(s > e){
            return 0;
        }
        int option1 = arr[s]+solve(arr, s+2, e);
        int option2 = 0+solve(arr, s+1, e);
        int finalAns = Math.max(option1,option2);
        return finalAns;
    }
    public static int maxAmount(int arr[]){
        int n = arr.length;
        int s = 0;
        int end = n-1;
        int ans = solve(arr, s, end);
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,1};
        System.out.println("Maximum Amount robbed is: "+maxAmount(arr));
    }
}
