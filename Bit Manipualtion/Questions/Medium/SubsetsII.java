/*
L.C: 90. Subsets II

Given an integer array nums that may contain duplicates, return all possible 
subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:
Input: nums = [0]
Output: [[],[0]]

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    // Time Complexity: O(n*2^n)

    // public static List<List<Integer>> subsetsWithDup(int[] nums) {
    //     int n = nums.length;
    //     List<List<Integer>> ans = new ArrayList<>();
    //     Arrays.sort(nums);
    //     int subsets = 1<<n;
    //     for(int i = 0;i<subsets;i++){
    //         List<Integer> list = new ArrayList<>();
    //         boolean isDuplicate = false;
    //         for(int j = 0;j<n;j++){
    //             if((i&(1<<j)) != 0 ){
    //                 if(j > 0 && nums[j] == nums[j-1] && (i&(1<<(j-1))) == 0){
    //                     isDuplicate = true;
    //                     break;
    //                 }
    //                 list.add(nums[j]);
    //             }
    //         }
    //         if(!isDuplicate)
    //         ans.add(list);
    //     }
    //     return ans;
    // }

    // Time Complexity: O(2^n)


    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        backTrack(nums,0,list,ans);
        return ans;
    }
    public static void backTrack(int nums[],int index,List<Integer> list,List<List<Integer>> ans){
        ans.add(new ArrayList<>(list));
        for(int i = index;i<nums.length;i++){
            if(i>index && nums[i] == nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            backTrack(nums, i+1, list, ans);
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        List<List<Integer>> ans = subsetsWithDup(nums);
        System.out.println(ans);
    }
}
