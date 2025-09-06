/*
L.C: 3202. Find the Maximum Length of Valid Subsequence II

You are given an integer array nums and a positive integer k.
A subsequence sub of nums with length x is called valid if it satisfies:

(sub[0] + sub[1]) % k == (sub[1] + sub[2]) % k == ... == (sub[x - 2] + sub[x - 1]) % k.
Return the length of the longest valid subsequence of nums.
 
Example 1:
Input: nums = [1,2,3,4,5], k = 2
Output: 5
Explanation:
The longest valid subsequence is [1, 2, 3, 4, 5].

Example 2:
Input: nums = [1,4,2,3,1,4], k = 3

Output: 4
Explanation:
The longest valid subsequence is [1, 4, 1, 4].

Constraints:
2 <= nums.length <= 10^3
1 <= nums[i] <= 10^7
1 <= k <= 10^3 
*/

// Time Complexity : O(n^2)
// Space Complexity : O(n*k)

import java.util.Arrays;

public class MaxLenValidSubsequenceII {
    public static int maximumLength(int[] nums, int k) {
      int n = nums.length;
        int[][] dp = new int[n][k];
        int maxSub = 1;

        for(int i[] : dp){
            Arrays.fill(i,1);
        }
        for(int i = 1; i<n; i++){
            for(int j = 0; j<i; j++){
                int mod = (nums[j] + nums[i])%k;
                dp[i][mod] = 1 + dp[j][mod];
                maxSub = Math.max(maxSub, dp[i][mod]);
            }
        }
        return maxSub;  
    }
    public static void main(String[] args) {
        int nums[] = {1,4,2,3,1,4};
        int k = 3;
        System.out.println(maximumLength(nums, k));
    }
}
