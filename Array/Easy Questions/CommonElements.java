/*
Given three arrays sorted in increasing order. Find the elements that are common in all three arrays.
Note: can you take care of the duplicates without using any additional Data Structure?

Example 1:

Input:
n1 = 6; A = {1, 5, 10, 20, 40, 80}
n2 = 5; B = {6, 7, 20, 80, 100}
n3 = 8; C = {3, 4, 15, 20, 30, 70, 80, 120}
Output: 20 80
Explanation: 20 and 80 are the only
common elements in A, B and C.

*/

import java.util.Arrays;
public class CommonElements {
    public static int[] commonElements(int arr1[],int arr2[],int arr3[]){
        int i = 0;
        int k = 0;
        int j = 0;
        int result[] = new int[100];
        int lastprint = Integer.MIN_VALUE;
        int index = 0;
        while(i<arr1.length && j<arr2.length && k<arr3.length){
            if(arr1[i]==arr2[j] && arr2[j]==arr3[k]){
                if(arr1[i] != lastprint){
                result[index++] = arr1[i];
                lastprint = arr1[i];
            }
            i++;
            j++;
            k++;
            }
            else if(arr1[i]<arr2[j]){
                i++;
            }
            else if(arr2[j]<arr3[k]){
                j++;
            }
            else{
                k++;
            }
        }
        return Arrays.copyOf(result, index);
    }
public static void main(String[] args) {
    // int arr1[] = new int[]{1, 5, 10, 20, 40, 80};
    // int arr2[] = new int[]{6, 7, 20, 80, 100};       
    // int arr3[] = new int[]{3, 4, 15, 20, 30, 70, 80, 120};
    int arr1[] = new int[]{3,3,3,3};
    int arr2[] = new int[]{3,3,3,3};       
    int arr3[] = new int[]{3,3,3,3};
    int[] ans = commonElements(arr1, arr2, arr3);
    for(int i : ans){
        System.out.print(i+" ");
        }
    }
}
