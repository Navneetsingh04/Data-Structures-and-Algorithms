/*
L.C: 2401. Longest Nice Subarray

You are given an array nums consisting of positive integers.
We call a subarray of nums nice if the bitwise AND of every pair of elements that are in different positions in the subarray is equal to 0.

Return the length of the longest nice subarray.
A subarray is a contiguous part of an array.
Note that subarrays of length 1 are always considered nice.


Example 1:
Input: nums = [1,3,8,48,10]
Output: 3
Explanation: The longest nice subarray is [3,8,48]. This subarray satisfies the conditions:
- 3 AND 8 = 0.
- 3 AND 48 = 0.
- 8 AND 48 = 0.
It can be proven that no longer nice subarray can be obtained, so we return 3.

Example 2:
Input: nums = [3,1,5,11,13]
Output: 1
Explanation: The length of the longest nice subarray is 1. Any subarray of length 1 can be chosen.
 
Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109 
*/
public class LongestNiceSubarry {

    // Approach 1: 
    // T.C: O(n^2)

    public static boolean isNice(int nums[],int i,int j){
        int mask =0;
        for(int k = i;k<=j;k++){
            if((mask & nums[k]) != 0){
                return false;
            }
            mask |= nums[k];
        }
        return true;
    }
    public static int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                if(isNice(nums,i,j)){
                    count = Math.max(count,j-i+1);
                }
                else{
                    break;
                }
            }
        }
        return count;
    }

    // Approach 2:  
    // T.C: O(n)

    public static int longestNiceSubarrayI(int[] nums) {
        int n = nums.length;
        int count = 0;
        int left = 0,bitmask = 0;
        for(int i = 0;i<n;i++){
            while((bitmask & nums[i]) != 0){
                bitmask ^= nums[left];
                left++;
            }
            bitmask |= nums[i];
            count = Math.max(count,i-left+1);
        }
        return count;
    }
   public static void main(String[] args) {
        int nums[] = {1,3,8,48,10};
        System.out.println(longestNiceSubarray(nums));
        System.out.println(longestNiceSubarrayI(nums));
   } 
}
