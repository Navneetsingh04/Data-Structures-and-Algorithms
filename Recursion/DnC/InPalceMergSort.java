/*
L.C: 912. Sort an Array

Given an array of integers nums, sort the array in ascending order and return it.

You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.

Example 1:
Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).

Example 2:
Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]
Explanation: Note that the values of nums are not necessairly unique.
 

Constraints:

1 <= nums.length <= 5 * 104
-5 * 104 <= nums[i] <= 5 * 104
*/
public class InPalceMergSort {
    public static void mergInPlace(int arr[],int start,int end,int mid){
        int totalLen = end-start+1;
        int gap = totalLen/2 + totalLen%2;

        while(gap>0){
            int i = start;
            int j = start+gap;
            while(j <= end){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                i++;
                j++;
            }
            gap = gap <= 1 ?0: (gap/2)+(gap%2);
        }
    }
    public static void mergSort(int arr[],int start,int end){
        if(start >= end){
            return;
        }
        int mid = start+(end-start)/2;
        mergSort(arr, start, mid);
        mergSort(arr,mid+1,end);
        mergInPlace(arr,start,end,mid);
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1,8,4,5,9,7,2,15,48};
        int start = 0;
        int end = arr.length-1;
        System.out.print("Array after sorting: ");
        mergSort(arr, start, end);
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}