/*
You are given an array of integers containing both positive and negative numbers. Your task is to shift all the negative numbers to the left side of the array while keeping the order of positive numbers unchanged. The goal is to achieve this in linear time complexity and without using any additional data structures.

Write a function or algorithm to solve this problem efficiently. The function should take the array of integers as input and modify the array in place to shift all negative numbers to the left side.

For example:

Input: [4, -3, 5, -2, -1, 0, 1, 2, -3]
Output: [-3, -2, -1, -3,5, 0, 1, 2,4]

Constraints:

The input array will contain at most 10^5 integers.
The integers in the array can range from -10^9 to 10^9.
The order of positive numbers should remain unchanged after shifting the negative numbers.

 */
public class ShiftingNegative {
    public static void shiftNegative(int arr[]){
        int j = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]<0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = new int[]{4, -3, 5, -2, -1, 0, 1, 2, -3};
        System.out.print("Printing array before shifting: ");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.print("\nPrinting array after shifting: ");
        shiftNegative(arr);
    }
}
