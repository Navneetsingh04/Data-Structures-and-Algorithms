/*
L.C:  137. Single Number II

Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.
Example 1:
Input: nums = [2,2,3,2]
Output: 3

Example 2:
Input: nums = [0,1,0,1,0,1,99]
Output: 99
 
Constraints:
1 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
Each element in nums appears exactly three times except for one element which appears once.
*/

public class SingleNumberII {
    // public static int singleNumber(int[] nums) {
    //     int n = nums.length;
    //     Arrays.sort(nums);
    //     for(int i = 1;i<n;i += 3){
    //         if(nums[i] != nums[i-1]){
    //             return nums[i-1];
    //         }
    //     }
    //    return nums[n-1];
    // }
    public static int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        for(int i = 0;i<nums.length;i++){
            ones = (ones^nums[i])&(~twos);
            twos = (twos^nums[i])&(~ones);
        }
        return ones;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,3,1,2,2,1};
        System.out.println(singleNumber(nums));
    }
}
