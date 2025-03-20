/*
Longest Bitonic subsequence

Given an array of positive integers. Find the maximum length of Bitonic subsequence. 
A subsequence of array is called Bitonic if it is first strictly increasing, then strictly decreasing. Return the maximum length of bitonic subsequence.
 
Note : A strictly increasing or a strictly decreasing sequence should not be considered as a bitonic sequence

Examples:
Input: n = 8, nums[] = [1, 11, 2, 10, 4, 5, 2, 1]
Output: 6
Explanation: The bitonic sequence {1, 2, 10, 4, 2, 1} has length 6.

Constraints:
1 ≤ length of array ≤ 10^3
1 ≤ arr[i] ≤ 10^4
*/

// T.C: O(n^2)*O(n^2)*O(n) ~ O(n^2)

import java.util.Arrays;
public class LongestBitonicSubsequences {
    public static int longestBitonicSequence(int n, int[] nums) {
        int dp1[] = new int[n];
        Arrays.fill(dp1,1);
        for(int i = 0;i<n;i++){
            for(int j = 0;j<i;j++){
                if(nums[j] < nums[i] && dp1[j]+1 > dp1[i]){
                    dp1[i] = 1+dp1[j];
                }
            }
        }
        
        int dp2[] = new int[n];
        Arrays.fill(dp2,1);
        for(int i = n-1;i>=0;i--){
            for(int j = i+1;j<n;j++){
                if(nums[j] < nums[i] && dp2[j]+1 > dp2[i]){
                    dp2[i] = 1+dp2[j];
                }
            }
        }
        int maxi = 0;
        for(int i = 0;i<n;i++){
            if(dp1[i] > 1 && dp2[i]>1){
                 maxi = Math.max(maxi,dp1[i] + dp2[i] - 1);   
            }
        }
        return maxi;
    }
    public static void main(String[] args) {
        int nums[] = {1,11,2,10,4,5,2,1};
        int n = nums.length;
        System.out.println(longestBitonicSequence(n, nums));
    }
}
