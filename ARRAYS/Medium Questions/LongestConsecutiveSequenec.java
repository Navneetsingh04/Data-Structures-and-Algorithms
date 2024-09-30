

/*
L.C: 128. Longest Consecutive Sequence

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Example 1
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109 
*/

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequenec {

    // Approach 1 : Brute force
    // Time complexity : O(n^2)

    // public static boolean linearSearch(int arr[],int target){
    //     int n = arr.length;
    //     for(int i = 0;i<n;i++){
    //         if(arr[i] == target){
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    // public static int longestConsecutive(int[] nums) {
    //     int n = nums.length;
    //     if(n == 0){
    //         return 0;
    //     }
    //     int longest = 1;
    //     for(int i = 0;i<n;i++){
    //         int x = nums[i];
    //         int count = 1;
    //         while(linearSearch(nums, x+1)){
    //             x++;
    //             count++;
    //         }
    //         longest = Math.max(longest, count);
    //     }
    //     return longest;
    // }

    // Approach 2 : 
    // Time Complexity: O(n)

    // public static int longestConsecutive(int[] nums) {
    //     Arrays.sort(nums);
    //     int n = nums.length;
    //     int longest = 1;
    //     int lastSmaller = Integer.MIN_VALUE;
    //     int count = 0;
    //     if(n == 0){
    //         return 0;
    //     }
    //     for(int i = 0;i<n;i++){
    //         if(nums[i]-1 == lastSmaller){
    //             count++;
    //             lastSmaller = nums[i];
    //         }
    //         else if(nums[i] != lastSmaller){
    //             count = 1;
    //             lastSmaller = nums[i];
    //         }
    //         longest = Math.max(longest,count);
    //     }
    //     return longest;
    // }

    // Approach 3 : Using hashSet 
    // Time Complexity: O(n)
    public static int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int longest = 1;
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<n;i++){
            set.add(nums[i]);
        }
        for(int i : set){
            if(!set.contains(i-1)){
                int curr = i;
                int count = 1;
                while(set.contains(curr +1)){
                    curr++;
                    count++;
                }
                longest = Math.max(longest,count);
            }
        }
        return longest;
    }
    public static void main(String[] args) {
        int nums[] = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }
}