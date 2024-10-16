/*
L.C : 33. Search in Rotated Sorted Array

There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
 
Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104
 */
// Time complexity : O(logn)
public class SearchinRotatedArray {
    public static int findPivotElement(int arr[]){
        int n = arr.length;
        int s = 0;
        int end = n-1;
        while(s<=end){
            int mid = s+(end-s)/2; 
            // corner case
            if(s==end){
                return s;
            }
            // mid-1 >=0 to avoid acessing the extra index
            if(mid-1 >= 0 && arr[mid]<arr[mid-1]){ 
                return mid-1;
            }
             // mid-1 <n to avoid acessing the extra index
            else if(mid+1<n && arr[mid]>arr[mid+1]){
                return mid;
            }
            else if(arr[s]>arr[mid]){
                end = mid-1;
            }
            else{
                s = mid+1;
            }
        }
        return -1;
    }
    public static int binarySearch(int arr[],int s,int e,int target){
        while(s<=e){
            int mid = s+(e-s)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid]<target){
                s = mid+1;
            }
            else{
                e = mid-1;
            }
        }
        return -1;
    }
    public static int serach(int arr[],int target){
        int pivotindex = findPivotElement(arr);
        int ans = -1;
        if (pivotindex == -1) {
            // Array is not rotated, perform binary search directly
            ans = binarySearch(arr, 0, arr.length - 1, target);
        }
        if(target >= arr[0] && target <= arr[pivotindex]){
            ans = binarySearch(arr,0,pivotindex,target);
        }
        else{
            ans = binarySearch(arr,pivotindex+1,arr.length-1,target);
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{5,6,7,8,9,10,1,2,3};
        int result = serach(arr, 12);
        System.out.println(result);
    }
}