/*
Dutch National Flag problem
L.C : 75 Sort Colors

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.
Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
Constraints:
n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
 */

// 1st Approach: Counting Method
// Time complexity : O(2n)
 // space complexity : O(1)
public class SortColors {

    // public static void sortColors(int arr[]){
        // int count0 = 0,count1 = 0,count2 = 0;
        // for(int i = 0;i<arr.length;i++){
        //     if(arr[i]==0){
        //         count0++;
        //     }
        //     else if(arr[i]==1){
        //         count1++;
        //     }
        //     else{
        //         count2++;
        //     }
        // }
        // for(int i = 0;i<count0;i++){
        //     arr[i] = 0;
        // }
        // for(int i = count0;i<count0+count1;i++){
        //     arr[i] = 1;
        // }
        // for(int i = count0+count1;i<arr.length;i++){
        //     arr[i] = 2;
        // }
        // for(int i :arr){
        //     System.out.print(i+" ");
        // }
        // System.out.println();
        // }

    // 2nd Approach: Two pointer
    // Time complexity : O(n)
    // space complexity : O(1)

    static void swap(int[] arr,int l,int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
    public static void sortColors(int arr[]){
        int left = 0;
        int mid = 0;
        int right = arr.length-1;
        while(mid <= right){
            if(arr[mid] == 0){
                swap(arr,mid,left);
                left++;
                mid++;
            }
            else if(arr[mid] == 2){
                swap(arr,mid,right);
                right--;
            }
            else{
                mid++;
            }
        }
        for(int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = new int[]{2,0,2,1,1,0};
        sortColors(arr);
    }
}
