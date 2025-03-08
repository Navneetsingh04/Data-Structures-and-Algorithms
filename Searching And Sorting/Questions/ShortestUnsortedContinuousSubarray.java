/*
L.C:  581. Shortest Unsorted Continuous Subarray

Given an integer array nums, you need to find one continuous subarray such that if you only sort this subarray in non-decreasing order, then the whole array will be sorted in non-decreasing order.
Return the shortest such subarray and output its length.

Example 1:

Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Example 2:

Input: nums = [1,2,3,4]
Output: 0
Example 3:

Input: nums = [1]
Output: 0

Constraints:
1 <= nums.length <= 104
-105 <= nums[i] <= 105
 
*/
public class ShortestUnsortedContinuousSubarray {
    private static int findUnsortedSubarray(int nums[]){
        int n = nums.length;
        if(n == 0) return 0;
        int left = 0;
        int right = n-1;
        while(left < n-1 && nums[left] <= nums[left+1]){
            left++;
        }
        while(right > 0 && nums[right] >= nums[right-1]){
            right--;
        }
        if(left == n-1){
            return 0;
        }
        int subMini = Integer.MAX_VALUE;
        int subMaxi = Integer.MIN_VALUE;
        for(int i = left;i<=right;i++){
            subMini = Math.min(subMaxi,nums[i]);
            subMaxi = Math.max(subMaxi,nums[i]);
        }
        while(left > 0 && nums[left-1] > subMini){
            left--;
        }
        while(right < n-1 && nums[right+1] < subMaxi){
            right++;
        }
        return right-left+1;
    }
    public static void main(String[] args) {
        int nums[] = {2,6,4,8,10,9,15};
        System.out.println(findUnsortedSubarray(nums));
    }
}
