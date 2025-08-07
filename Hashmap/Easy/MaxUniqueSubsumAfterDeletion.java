/*
L.C: 3487. Maximum Unique Subarray Sum After Deletion

You are given an integer array nums.

You are allowed to delete any number of elements from nums without making it empty. After performing the deletions, select a subarray of nums such that:

All elements in the subarray are unique.
The sum of the elements in the subarray is maximized.
Return the maximum sum of such a subarray.

Example 1:
Input: nums = [1,2,3,4,5]
Output: 15
Explanation:
Select the entire array without deleting any element to obtain the maximum sum.

Example 2:

Input: nums = [1,1,0,1,1]
Output: 1
Explanation:
Delete the element nums[0] == 1, nums[1] == 1, nums[2] == 0, and nums[3] == 1. Select the entire array [1] to obtain the maximum sum.

Example 3:
Input: nums = [1,2,-1,-2,1,0,-1]
Output: 3

Explanation:

Delete the elements nums[2] == -1 and nums[3] == -2, and select the subarray [2, 1] from [1, 2, 1, 0, -1] to obtain the maximum sum.

Constraints:
1 <= nums.length <= 100
-100 <= nums[i] <= 100 
*/
// Time Complexity : 0(n)
// space Complexity : 0(n)

import java.util.HashSet;
import java.util.Set;

public class MaxUniqueSubsumAfterDeletion {
    public static int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0,maxNeg = Integer.MIN_VALUE;
        
        for(int num : nums){
            if(num <= 0){
                maxNeg = Math.max(maxNeg,num);
            }
            else if(!set.contains(num)){
                sum += num;
                set.add(num);
            }
        }
        return sum == 0 ? maxNeg : sum;
    }
    public static void main(String[] args) {
        int nums[] = {2,-10,6};
        System.out.println(maxSum(nums));
    }
}
