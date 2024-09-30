/*
L.C: 493. Reverse Pairs

Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i, j) where:

0 <= i < j < nums.length and
nums[i] > 2 * nums[j].
 

Example 1:

Input: nums = [1,3,2,3,1]
Output: 2
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
Example 2:

Input: nums = [2,4,3,5,1]
Output: 3
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
(2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1
 

Constraints:

1 <= nums.length <= 5 * 104
-231 <= nums[i] <= 231 - 1 
*/

import java.util.ArrayList;

public class ReversePairs {
    public static void merg(int arr[],int low,int high,int mid){
        ArrayList<Integer> temp = new ArrayList<>();
        int i = low;
        int j = mid+1;
        while(i <= mid && j <= high){
            if(arr[i] <= arr[j]){
                temp.add(arr[i]);
                i++;
            }
            else{
                temp.add(arr[j]);
                j++;
            }
        }
        while(i <= mid){
            temp.add(arr[i]);
            i++;
        }
        while(j <= high){
            temp.add(arr[j]);
            j++;
        }
        for(int l = low;l<=high;l++){
            arr[l] = temp.get(l-low);
        }
    }
    public static int countPair(int arr[],int low,int high,int mid){
        int right = mid+1;
        int count = 0;
        for(int i = low;i<=mid;i++){
            while(right <= high && arr[i] > 2L*arr[right]){
                right++;
            }
            count += (right-(mid+1));
        }
        return count;
    }
    public static int mergSort(int arr[],int low,int high){
        if(low >= high){
            return 0;
        }
        int mid = low+(high-low)/2;
        int count = 0;
        count += mergSort(arr,low,mid);
        count += mergSort(arr,mid+1,high);
        count += countPair(arr,low,high,mid);
        merg(arr,low,high,mid);
        return count;
    }
    public static int reversePairs(int[] nums) {
        int n = nums.length;
        return mergSort(nums,0,n-1);
    }
    public static void main(String[] args) {
        int arr[] = {1,3,2,3,1};
        System.out.println(reversePairs(arr));
    }
}
