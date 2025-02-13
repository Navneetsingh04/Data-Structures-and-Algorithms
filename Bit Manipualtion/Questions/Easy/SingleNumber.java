/*
L.C: 136. Single Number

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1
Constraints:

1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once. 
*/
public class SingleNumber {
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static int singleNumber(int[] nums){
        for(int i = 0;i<nums.length;i++){
            int n = nums[i];
            int count =0;

            for(int j = 0;j<nums.length;j++){
                if(nums[j] == n){
                    count++;
                }
            }
            if(count == 1){
                return n;
            }
        }
        return -1;
    }
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // public static int singleNumber(int[] nums) {
    //     int ans = 0;
    //     for(int i: nums){
    //         ans = i^ans;
    //     }
    //     return ans;
    // }
    public static void main(String[] args) {
        int nums[] = {1,2,2,1,3,3,4};
        System.out.println("Single Number in the array is: "+singleNumber(nums));
    }
}
