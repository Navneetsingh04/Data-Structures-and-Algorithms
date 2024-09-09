/*
L.C:  260. Single Number III

Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.

You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

Example 1:
Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.

Example 2:
Input: nums = [-1,0]
Output: [-1,0]
Example 3:

Input: nums = [0,1]
Output: [1,0]
 
Constraints:
2 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
Each integer in nums will appear twice, only two integers will appear once.
*/

public class SingleNumberIII {
    // public static int[] singleNumber(int[] nums) {
    //     Map<Integer,Integer> map = new HashMap<>();
    //     int ans[] = new int[2];
    //     for(int i :nums){
    //         map.put(i,map.getOrDefault(i,0)+1);
    //     }   
    //     int index = 0;
    //     for(Map.Entry<Integer,Integer> entry : map.entrySet()){
    //         if(entry.getValue() == 1){
    //             ans[index++] = entry.getKey();
    //         }
    //     }
    //     return ans;
    // }
    public static int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int i : nums){
            xor = xor^i;
        }
        int rightMost = (xor^xor-1)&xor;
        int b1 = 0;
        int b2 = 0;
        for(int i : nums){
            if((i&rightMost) == 0){
                b1 = b1^i;
            }
            else{
                b2 = b2^i;
            }
        }
        int ans[] = new int[2];
        ans[0] = b1;
        ans[1] = b2;
        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,1,3,2,5};
        int ans[] = singleNumber(nums);
        for(int i : ans){
            System.out.print(i+" ");
        }
    }
}
