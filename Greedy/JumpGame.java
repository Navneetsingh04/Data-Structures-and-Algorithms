/*
L.C: 55. Jump Game

You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.
Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 
Constraints:
1 <= nums.length <= 104
0 <= nums[i] <= 105 
*/
// Time Compexity: O(n)
// Space Compexity: O(1)
public class JumpGame {
    private static boolean canJump(int nums[]){
        int n = nums.length;
        int max = 0;
        for(int i = 0;i<n;i++){
            if(max < i){
                return false;
            }
            max = Math.max(max,i+nums[i]);
        }
        return true;
    }
    public static void main(String[] args) {
        int nums[] = {2,3,1,1,4};
        // int nums[] = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }
}
