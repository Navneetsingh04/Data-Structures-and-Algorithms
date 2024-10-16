/*
L.c : 189. Rotate Array
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105
 */
import java.util.Scanner;

// 1st Approach : Using modulus operatoar

// Time complexity : O(n)
// space complexity : O(n)

// public class RotateArray {
//     public static void shiftKelemnt(int arr[],int k){
//         int n = arr.length;
//         int ans[] = new int[n];
//         for(int i = 0;i<n;i++){
//             int newIndex = (i+k)%n;
//             ans[newIndex] = arr[i];
//         }
//         // copying ans array to arr
//         for(int i = 0;i<n;i++){
//             arr[i] = ans[i];
//         }
//         System.out.print("Printing array after Shifting "+k+" positions: ");
//         for(int i: arr){
//             System.out.print(i+" ");
//         }
//         System.out.println();
//     }

// 2nd Approach: dividing Array into Two Parts

// Time complexity : O(n)
// space complexity : O(1)

public class RotateArray{
    public static void reverse(int arr[],int left,int right){
        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    public static void shiftKelemnt(int arr[],int k){
        int n = arr.length;
        k = k%n;
        reverse(arr,0,n-1);
        reverse(arr,0,k-1);
        reverse(arr,k, n-1);
       
        for(int i: arr){
            System.out.print(i+" ");
        }
    }
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the size of the Array: ");
        int size = s.nextInt();
        System.out.print("Enter the element in the array: ");
        int arr[] = new int[size];
        for(int i = 0;i<arr.length;i++){
            arr[i] = s.nextInt();
        }
        System.out.print("Printing array before Shifting: ");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.print("\nEnter the number of element you want to shift: ");
        int k = s.nextInt();
        System.out.print("Printing array after Shifting "+k+" positions: ");
        shiftKelemnt(arr,k);
        s.close();
    }
}