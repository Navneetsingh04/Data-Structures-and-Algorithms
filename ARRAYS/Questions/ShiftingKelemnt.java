/*
You are given an array of integers arr of length n and an integer k. Your task is to shift the last k elements of the array to the right by k positions, such that the elements wrap around to the beginning of the array.

Write a program to perform this operation efficiently.

Input:

The first line of input contains an integer n representing the size of the array.
The second line contains n space-separated integers representing the elements of the array.
The third line contains an integer k representing the number of elements to shift.
Output:

Output the modified array after shifting k elements to the right.
Example:

Input:

Copy code
6
1 2 3 4 5 6
3
Output:

Copy code
4 5 6 1 2 3
Constraints:

1 <= n <= 10^5
1 <= k <= n

 */
import java.util.Scanner;
public class ShiftingKelemnt {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the size of the Array: ");
        int size = s.nextInt();
        System.out.println("Enter the element in the array: ");
        int arr[] = new int[size];
        for(int i = 0;i<arr.length;i++){
            arr[i] = s.nextInt();
        }
        System.out.print("Printing array before Shifting: ");
        for(int i:arr){
            System.out.print(i+" ");
        }
        // int arr[] = new int[]{4,54,5,45,8,7};
        System.out.print("\nEnter the number of element you wnat to shift: ");
        int element = s.nextInt();
        // storing last element in the temp array
        int temp[] = new int[element];
        for(int i = 0;i<element;i++){
            temp[i] = arr[arr.length - element+i];
        }
        // Shifting elemnt to the right
        for(int i = arr.length-1;i>=element;i--){
            arr[i] = arr[i-element];
        }
        // copy temp array to arr
        for(int i = 0;i<element;i++){
            arr[i] = temp[i];
        }
        System.out.print("Printing array after Shifting "+element+" positions: ");
        for(int i:arr){
            System.out.print(i+" ");
        }
        s.close();
    }
}
