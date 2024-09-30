/*
Design and implement a function that checks whether an array of integers is sorted in non-decreasing order. The function should take an array of integers as input and return a boolean value indicating whether the array is sorted in non-decreasing order or not.

Constraints:

The array may contain both positive and negative integers.
The array may have duplicates.
The length of the array is not fixed and can vary.
The integers in the array may not be contiguous.
 */
public class CheckSort {
    public static boolean checkSort(int arr[]){
        for(int i =0;i<arr.length-1;i++){
            if(arr[i] >arr[i+1]){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        // int arr[] = new int[]{1,2,3,-4,5,6};
        int arr[] = new int[]{1,2,3,4,5,6};
        // int arr[] = new int[]{11,2,3,4,5,6};
        boolean result = checkSort(arr);
        if(result){
            System.out.println("Array is sorted");
        }
        else{
            System.out.println("Array is not sorted");
        }

    }
}
