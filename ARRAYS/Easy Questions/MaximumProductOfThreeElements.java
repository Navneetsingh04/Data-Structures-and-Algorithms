/*
L.C: 628. Maximum Product of Three Numbers
Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

Example 1:
Input: nums = [1,2,3]
Output: 6

Example 2:
Input: nums = [1,2,3,4]
Output: 24

Example 3:
Input: nums = [-1,-2,-3]
Output: -6

Constraints:

3 <= nums.length <= 104
-1000 <= nums[i] <= 1000 
*/
// Time Complexity : O(n)
// Space Complexity : O(1)
public class MaximumProductOfThreeElements {
    public static int maximumProduct(int[] nums) {
        int firstMax = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;

        // for handling negative products
        int firstMin = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;

        for (int i : nums) {
            // Update the largest numbers
            if (i > firstMax) {
                thirdMax = secMax;
                secMax = firstMax;
                firstMax = i;
            } 
            else if (i > secMax) {
                thirdMax = secMax;
                secMax = i;
            } 
            else if (i > thirdMax) {
                thirdMax = i;
            }

            // Update the smallest numbers
            if(i < firstMin) {
                secMin = firstMin;
                firstMin = i;
            } 
            else if (i < secMin) {
                secMin = i;
            }
        }
        int product1 = firstMax * secMax * thirdMax;
        int product2 = firstMax * firstMin * secMin;
        return Math.max(product1, product2);
    }
    public static void main(String[] args) {
        int nums[] = {-100,-98,-1,2,3,4};
        System.out.println(maximumProduct(nums));
    }
}
