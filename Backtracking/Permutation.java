/*
L.C: 46. Permutations

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:
1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique. 
*/
// Time Complexity: O(n!*n)
// space complexity: O(n)+O(n)
import java.util.ArrayList;
import java.util.List;

public class Permutation {
    // public static void permutation(int nums[],List<Integer> list,List<List<Integer>> ans,boolean freq[]){
    //     if(list.size() == nums.length){
    //         ans.add(new ArrayList<>(list));
    //         return;
    //     }
    //     for(int i = 0;i<nums.length;i++){
    //         if(!freq[i]){
    //             freq[i] = true;
    //             list.add(nums[i]);
    //             permutation(nums,list,ans,freq);
    //             list.remove(list.size()-1);
    //             freq[i] = false;
    //         }
    //     }
    // }
    // public static List<List<Integer>> permute(int[] nums) {
    //     List<Integer> list = new ArrayList<>();
    //     List<List<Integer>> ans = new ArrayList<>();
    //     boolean freq[] = new boolean[nums.length];
    //     permutation(nums,list,ans,freq);
    //     return ans;

    public static  void permutation(int index,int nums[],List<List<Integer>> ans){
        if(index == nums.length){
            // copy list to ans
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i<nums.length;i++){
                list.add(nums[i]);
            }
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = index;i<nums.length;i++){
            swap(i,index,nums);
            permutation(index+1,nums,ans);
            swap(i,index,nums);
        }
    }
    public static void swap(int i,int j, int nums[]){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permutation(0,nums,ans);
        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        List<List<Integer>> ans = permute(nums);
        System.out.println(ans);
    }
}
