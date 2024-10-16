/*
L.C: 39. Combination Sum

Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
frequency
of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
 

Constraints:

1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40
 */
// Time complexity : O(2^t * k)
// space Complexity: O(K*x)
import java.util.ArrayList;
import java.util.List; 
public class CombinationSum {
    public static void combinationSumHelpher(int arr[],int target,List<Integer> list,List<List<Integer>> ans,int index){
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target < 0){
            return;
        }
        for(int i = index;i<arr.length;i++){
            list.add(arr[i]);
            combinationSumHelpher(arr, target-arr[i], list, ans, i);
            list.remove(list.size()-1);
        }
    }
    public static List<List<Integer>> combinationSum(int candidate[],int target){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinationSumHelpher(candidate,target,list,ans,0);
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{2,3,6,7};
        int target = 7;
        System.out.println("Combination of for target Sum is: "+combinationSum(arr, target));
    }
}