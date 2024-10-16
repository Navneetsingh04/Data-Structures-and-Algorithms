/*
L.C: 448. Find All Numbers Disappeared in an 
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

Example 2:
Input: nums = [1,1]
Output: [2]
 
Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
*/
//  Time complexity = O(n)

import java.util.ArrayList;
public class FindDisapperedNum {
    public static ArrayList<Integer> findDisapperedNum(int arr[]){
        int n = arr.length;
        int i = 0;
        ArrayList<Integer> ans = new ArrayList<>();
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
        for(int index = 0;index<n;index++){
            if(arr[index] != index+1){
                ans.add(index+1);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{4,3,2,7,8,2,3,1};
        ArrayList<Integer> result = findDisapperedNum(arr);
        System.out.print("Missing element from the array is "+result+" ");
    }
}
