/*
L.C: 414. Third Maximum Number

Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.

Example 1:

Input: nums = [3,2,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2.
The third distinct maximum is 1.
Example 2:

Input: nums = [1,2]
Output: 2
Explanation:
The first distinct maximum is 2.
The second distinct maximum is 1.
The third distinct maximum does not exist, so the maximum (2) is returned instead.
Example 3:

Input: nums = [2,2,3,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2 (both 2's are counted together since they have the same value).
The third distinct maximum is 1.
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1 
*/
public class ThirdMaximum {
    public static int thirdMax(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        if(n == 2){
            return Math.max(nums[0],nums[1]);
        }
        long firstMax = Long.MIN_VALUE;
        long secMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;
        for(int i : nums){
            if(firstMax == i || secMax == i || thirdMax == i){
                continue;
            }
            if(i >= firstMax){
                thirdMax = secMax;
                secMax = firstMax;
                firstMax = i;
            }
            else if(i >= secMax){
                thirdMax = secMax;
                secMax = i;
            }
            else if(i >= thirdMax){
                thirdMax = i;
            }
        }
        if(thirdMax == Long.MIN_VALUE){
            int ans = (int)firstMax;
            return ans;
        }
        int ans = (int)thirdMax;
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {64,5,6,18,97,8,65,63,45};
        System.out.println(thirdMax(arr));
    }
}
