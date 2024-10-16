/*
47. Permutations II
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

Example 1:
Input: nums = [1,1,2]
Output:
[[1,1,2],
[1,2,1],
[2,1,1]]

Example 2:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
  
Constraints:
1 <= nums.length <= 8
-10 <= nums[i] <= 10
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set; 
public class PermutationII {
    public static void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void permutationHelpher(int arr[],List<List<Integer>> ans,int start){
        if(start == arr.length){
            List<Integer> current = new ArrayList<>();
            for (int num : arr) {
                current.add(num);
            }
            ans.add(current);
            return;
        }
        Set<Integer> visited = new HashSet<>();
        for(int i = start;i<arr.length;i++){
            // only proceed if the element is not visited
            if(visited.add(arr[i])){
            swap(arr, i, start);
            permutationHelpher(arr, ans, start+1);
            // backtrack
            swap(arr, i, start);
            }
        }
    }
    public static List<List<Integer>> permutation(int arr[]){
        List<List<Integer>> ans = new ArrayList<>();
        // sort to handle the duplicate
        Arrays.sort(arr);
        permutationHelpher(arr,ans,0);
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1,1,3};
        System.out.println(permutation(arr));
    }
}