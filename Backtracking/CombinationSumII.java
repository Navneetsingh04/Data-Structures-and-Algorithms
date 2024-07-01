/*
L.C: 40. Combination Sum II

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 
Constraints:
1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class CombinationSumII {
    public static void combiantionSumHelpher(int arr[],int target,List<Integer> list,List<List<Integer>> ans,int index){
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target < 0){
            return;
        }
        for(int i = index;i<arr.length;i++){
            if(i > index && arr[i] == arr[i-1]){
                continue;
            }
            list.add(arr[i]);
            combiantionSumHelpher(arr, target-arr[i], list, ans, i+1);
            list.remove(list.size()-1);
        }
    }
    public static List<List<Integer>> combiantionSum(int arr[],int target){
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combiantionSumHelpher(arr,target,list,ans,0);
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combiantionSum(arr, target));
    }
}