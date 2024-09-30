/*
L.C: 560. Subarray Sum Equals K
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:
Input: nums = [1,1,1], k = 2
Output: 2

Example 2:
Input: nums = [1,2,3], k = 3
Output: 2

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
 */

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    // Time complexity : O(n^2);
    // Space complexity: O(n)

    // public int subarraySum(int[] nums, int k) {
    //     int n = nums.length;
    //     int count = 0;
    //     for(int i = 0;i<n;i++){
    //         int sum = 0;
    //         for(int j = i;j<n;j++){
    //             sum += nums[j];
    //             if(sum == k){
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;
    // }

    // Time complexity : O(n);
    // Space complexity: O(n)
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0;i<nums.length;i++){
            sum += nums[i];
            if(map.containsKey(sum-k)){
                count += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        int nums[] = {1,1,1};
        int k = 2;
        System.out.println(subarraySum(nums, k));
    }
}
