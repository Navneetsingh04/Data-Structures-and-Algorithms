/*
L.C: 2962. Count Subarrays Where Max Element Appears at Least K Times

You are given an integer array nums and a positive integer k.

Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.
A subarray is a contiguous sequence of elements within an array.

Example 1:

Input: nums = [1,3,2,3,3], k = 2
Output: 6
Explanation: The subarrays that contain the element 3 at least 2 times are: [1,3,2,3], [1,3,2,3,3], [3,2,3], [3,2,3,3], [2,3,3] and [3,3].

Example 2:
Input: nums = [1,4,2,1], k = 3
Output: 0
Explanation: No subarray contains the element 4 at least 3 times.

Constraints:
1 <= nums.length <= 105
1 <= nums[i] <= 106
1 <= k <= 105 
*/

// Time Complexity: O(N)
// Space Complexity: O(1)

public class CountSubarrayMaxElementApperarsKTimes {
    public static long countSubarrays(int nums[],int k){
        int n = nums.length;
        int maxElement = nums[0];
        for(int i : nums){
            if(i > maxElement){
                maxElement = i;
            }
        }
        int i = 0,j = 0;
        long count = 0;
        int freq = 0;
        while(j<n){
            if(nums[j] == maxElement){
                freq++;
            }
            while(freq >= k){
                count += n-j;
                if(nums[i] == maxElement){
                    freq--;
                }
                i++;
            }
            j++;
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[] = {1,3,2,3,3};
        int k = 2;
        System.out.println(countSubarrays(arr,k));
    }
}
