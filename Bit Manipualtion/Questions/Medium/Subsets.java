/*
L.C: 78. Subsets

Given an integer array nums of unique elements, return all possible subsets(the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:
Input: nums = [0]
Output: [[],[0]]
 

Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique. 
*/

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        int subsets = 1<<n;
        for(int i = 0;i<subsets;i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0;j<n;j++){
                if((i&(1<<j)) != 0){
                    list.add(nums[j]);
                }
            }
            ans.add(list);
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        List<List<Integer>> ans = subsets(nums);
        System.out.println(ans);
    }
}
