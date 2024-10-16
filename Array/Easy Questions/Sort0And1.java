/*
Problem Statement: Sort 0's and 1's
You are given an array containing elements that can have one of two values: 0 or 1. Your task is to sort the array in-place such that all the 0s come before all the 1s. Additionally, you need to print all the 0s first followed by all the 1s.

Write a function or algorithm to solve this problem efficiently. The function should take the array of integers as input and modify the array in place to achieve the required sorting. Additionally, print all the 0s first followed by all the 1s.

For example:

Input: [1, 0, 1, 0, 1, 0]
Output: [0, 0, 0, 1, 1, 1]

Constraints:

The input array will contain at most 
1
0
4
10 
4
integers.
The integers in the array can only be 0 or 1.
 */
public class Sort0And1 {
    public static void main(String rags[]){
        int arr[] = new int[]{1,1,0,1,0,1,0,1,0,1,0,1,0,1,0};
        System.out.println("printing array before Sorting 0's and 1's");
        for(int i:arr){
            System.out.print(i+" ");
        }
        // 1st Method: using Count 0 and 1
        //  time complexity O(n)
        int count0 = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]==0){
                count0++;
            }
        }
        for(int i = 0;i<count0;i++){
            arr[i] = 0;
        }
        for(int i = count0;i<arr.length;i++){
            arr[i] = 1;
        }
        System.out.println("\nprinting after Sorting 0's and 1's");
        for(int i:arr){
            System.out.print(i+" ");
        }

        // Method 2: Using two Pointer

        // int l = 0;
        // int r = arr.length-1;
        // while(l<r){
        //     while(arr[l] == 0 && l<r){
        //         l++;
        //     }
        //     while(arr[r] == 1 && l<r){
        //         r--;
        //     }
        //     if(l<r){
        //         int temp = arr[l];
        //         arr[l] =arr[r];
        //         arr[r] =temp;
        //         l++;
        //         r--;
        //     }
        // }
        // System.out.println("\nprinting after Sorting 0's and 1's");
        // for(int i:arr){
        //     System.out.print(i+" ");
        // }
    }
}