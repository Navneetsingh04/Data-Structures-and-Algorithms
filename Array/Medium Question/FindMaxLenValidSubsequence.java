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
2 <= nums.length <= 2 * 105
1 <= nums[i] <= 107 
*/

// Time Complexity : O(n) 
// Time Complexity : O(1) 

public class FindMaxLenValidSubsequence {
    public static int maximumLength(int[] nums) {
        int n = nums.length;
        int even = 0,odd = 0;
        int alternate = 1;
        for(int num : nums){
            if((num&1) == 0) even++;
            else odd++;
        }
        int parity = nums[0]&1;
        for(int i = 1;i<n;i++){
            int currParity = nums[i]&1;
            if(currParity != parity){
                alternate++;
                parity = currParity;
            }
        }
        return Math.max(even,Math.max(odd,alternate));
    }
    public static void main(String[] args) {
        int nums[] = {1,2,1,1,2,1,2};
        System.out.println(maximumLength(nums));
    }
}
