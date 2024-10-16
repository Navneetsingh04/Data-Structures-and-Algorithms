/*
L.C: 34. Find First and Last Position of Element in Sorted Array

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.


Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109 
*/
import java.util.Arrays;
public class FindFirstAndLastPostion {
    public int first(int nums[],int target){
        int l = 0;
        int h = nums.length-1;
        int index = -1;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(nums[mid] == target){
                index = mid;
                h = mid-1;
            }
            else if(nums[mid] < target){
                l = mid+1;
            }
            else{
                h = mid-1;
            }
        }
        return index;
    }
    public int last(int nums[],int target){
        int l = 0;
        int h = nums.length-1;
        int index = -1;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(nums[mid] == target){
                index = mid;
                l = mid+1;
            }
            else if(nums[mid] < target){
                l = mid+1;
            }
            else{
                h = mid-1;
            }
        }
        return index;
    }
    public int[] searchRange(int[] nums, int target) {
        int ans[] = new int[2];
        ans[0] = first(nums,target);
        ans[1] = last(nums,target);
        return ans;
    }
    public static void main(String[] args) {
        FindFirstAndLastPostion find = new FindFirstAndLastPostion();
        int nums[] = {5,7,7,8,8,10};
        int target = 8;
        int ans[] = find.searchRange(nums, target);
        System.out.println(Arrays.toString(ans));

    }
}
