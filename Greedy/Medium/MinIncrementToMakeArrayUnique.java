/*
L.C: 945. Minimum Increment to Make Array Unique

You are given an integer array nums. In one move, you can pick an index i where 0 <= i < nums.length and increment nums[i] by 1.
Return the minimum number of moves to make every value in nums unique.
The test cases are generated so that the answer fits in a 32-bit integer.

Example 1:

Input: nums = [1,2,2]
Output: 1
Explanation: After 1 move, the array could be [1, 2, 3].

Example 2:
Input: nums = [3,2,1,2,1,7]
Output: 6
Explanation: After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
It can be shown that it is impossible for the array to have all unique values with 5 or less moves.
 
Constraints:
1 <= nums.length <= 105
0 <= nums[i] <= 105
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinIncrementToMakeArrayUnique {
    // Approach 1: Brute force
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    public static int minIncrementForUnique(int nums[]){
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int moves = 0;
        for(int i = 0;i<n;i++){
            while(set.contains(nums[i])){
                nums[i]++;
                moves++;
            }
            set.add(nums[i]);
        }
        return moves;
    }
    // Time Complexity: O(nlogn)
    // Space Complexity: O(n)
    public static int minIncrementForUniqueI(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int count = 0;
        for(int i = 1;i<n;i++){
            if(nums[i] <= nums[i-1]){
                int newVal = nums[i-1]+1;
                count += newVal - nums[i];
                nums[i] = newVal;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int  nums[] = {3,2,1,2,1,7};
        // System.out.println(minIncrementForUnique(nums));
        System.out.println(minIncrementForUniqueI(nums));
    }
}
