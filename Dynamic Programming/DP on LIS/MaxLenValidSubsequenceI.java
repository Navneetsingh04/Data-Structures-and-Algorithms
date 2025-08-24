/*
L.C: 3201. Find the Maximum Length of Valid Subsequence I

You are given an integer array nums.
A subsequence sub of nums with length x is called valid if it satisfies:

(sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x - 1]) % 2.
Return the length of the longest valid subsequence of nums.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.


Example 1:
Input: nums = [1,2,3,4]
Output: 4
Explanation:
The longest valid subsequence is [1, 2, 3, 4].

Example 2:
Input: nums = [1,2,1,1,2,1,2]
Output: 6
Explanation:
The longest valid subsequence is [1, 2, 1, 2, 1, 2].

Example 3:
Input: nums = [1,3]
Output: 2
Explanation:
The longest valid subsequence is [1, 3].

Constraints:
2 <= nums.length <= 2 * 10^5
1 <= nums[i] <= 10^7 
*/

// Time Complexity : O(n^2)  TLE 
// Space Complexity : O(n*2)

public class MaxLenValidSubsequenceI {
    public static int maximumLength(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[2][n]; // dp[0][i] for mod=0, dp[1][i] for mod=1
        int maxSub = 1;

        for(int i = 0;i<2;i++){
            for(int j = 0;j<n;j++){
                dp[i][j] = 1;
            }
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                int mod = (nums[j] + nums[i])%2;
                dp[mod][i] = Math.max(dp[mod][i], 1 + dp[mod][j]);
                maxSub = Math.max(maxSub, dp[mod][i]);
            }
        }
        return maxSub;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,1,1,2,1,2};
        System.out.println(maximumLength(nums));
    }
}
