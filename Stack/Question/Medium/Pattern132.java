/*
L.C: 456. 132 Pattern

Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].

Return true if there is a 132 pattern in nums, otherwise, return false.

Example 1:

Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.
Example 2:

Input: nums = [3,1,4,2]
Output: true
Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
Example 3:

Input: nums = [-1,3,2,0]
Output: true
Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 

Constraints:

n == nums.length
1 <= n <= 2 * 105
-109 <= nums[i] <= 109 
*/
import java.util.Stack;
public class Pattern132 {
    // Approach 1: Brute force
    // Time complexity : O(n^2)

    // public static boolean find132pattern(int nums[]){
    //     int n = nums.length;
    //     int mini = Integer.MAX_VALUE;
    //     for(int j = 0;j<n-1;j++){
    //         mini = Math.min(nums[j],mini);
    //         for(int k = j+1;k<n;k++){
    //             if((nums[k] < nums[j]) && (mini<nums[k])){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }


    // Approach 1: Stack
    // Time complexity : O(n)
    public static boolean find132pattern(int nums[]){
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        if(n<3) return false;
        int mini[] = new int[n];
        mini[0] = nums[0]; 
        for(int i = 1;i<n;i++){
            mini[i] = Math.min(mini[i-1],nums[i]);
        }
        for(int j = n-1;j>=0;j--){
            if(nums[j] > mini[j]){
                while(!st.isEmpty() && st.peek() <= mini[j]){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek() < nums[j]){
                    return true;
                }
                st.push(nums[j]);
            }
        }
        return  false;
    }
    public static void main(String[] args) {
        // int arr[] = {3,1,4,2};
        int arr[] = {1,0,1,-4,-3};
        System.out.println(find132pattern(arr));
    }
}
