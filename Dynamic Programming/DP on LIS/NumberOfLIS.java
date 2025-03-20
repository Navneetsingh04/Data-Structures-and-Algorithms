/*
L.C: 673. Number of Longest Increasing Subsequence

Given an integer array nums, return the number of longest increasing subsequences.
Notice that the sequence has to be strictly increasing.

Example 1:

Input: nums = [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].

Example 2:
Input: nums = [2,2,2,2,2]
Output: 5
Explanation: The length of the longest increasing subsequence is 1, and there are 5 increasing subsequences of length 1, so output 5.
 
Constraints:
1 <= nums.length <= 2000
-106 <= nums[i] <= 106
The answer is guaranteed to fit inside a 32-bit integer.
*/

// T.C: O(n^2)

import java.util.Arrays;

public class NumberOfLIS {
    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        int count[] = new int[n];
        Arrays.fill(count,1);
        int maxi = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<i;j++){
                if(nums[i] > nums[j] && dp[j]+1 > dp[i]){
                    dp[i] = 1+dp[j];
                    count[i] = count[j];
                }
                else if(nums[i] > nums[j] && dp[j]+1 == dp[i]){
                    count[i] += count[j];
                }
            }
            maxi = Math.max(maxi,dp[i]);
        }
        int maxCount = 0;
        for(int i= 0;i<n;i++){
            if(dp[i] == maxi){
                maxCount += count[i];
            }
        }
        return maxCount;
    }
    public static void main(String[] args) {
        int nums[] = {1,3,5,4,7};
        System.out.println(findNumberOfLIS(nums));
    }
}
