/*
L.C : 442. Find All Duplicates in an Array

Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.
 

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]
Example 2:

Input: nums = [1,1,2]
Output: [1]
Example 3:

Input: nums = [1]
Output: []
 
Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
Each element in nums appears once or twice
*/

// Time complexity : O(n)
import java.util.ArrayList;
import java.util.List;
public class FindAllDupliacte {
    static List<Integer> findAllDupliacte(int arr[]){
        int n = arr.length;
        int i = 0;
        List<Integer> ans = new ArrayList<>();
        while(i<n){
            int correctIndex = arr[i]-1;
            if(arr[i] != arr[correctIndex]){
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            }
            else{
                i++;
            }
        }
        for(i = 1;i<n;i++){
            if(arr[i] != i+1){
                ans.add(arr[i]);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> result = findAllDupliacte(arr);
        System.out.println("The Duplicate Elemnets in the array:  "+result);
    }
}
