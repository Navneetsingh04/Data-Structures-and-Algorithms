/*
You are given a sorted array. Your task is to implement a function that removes duplicate elements from the array in-place. The resulting array should have each element appearing only once, and the order of elements should be preserved.
Input: arr = [1, 1, 2, 2, 3, 4, 5, 5, 6]
arr: A sorted list of integers. (0 <= len(arr) <= 10^5)
Output: [1, 2, 3, 4, 5, 6]
Return an integer representing the new length of the array after removing duplicates.
Constraints:

The given array is sorted.
The removal of duplicates must be done in-place, i.e., you're not allowed to use another data structure to temporarily store elements.
The order of elements must be preserved.
*/
public class RemoveDuplicate {
    public static int removeDuplicate(int arr[]){
        if(arr.length == 0){
            return 0;
        }
        int index = 1;
        for(int i = 1;i<arr.length;i++){
            if(arr[i] != arr[index-1]){
                arr[index] = arr[i];
                index++;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1,1,2,2,3,3,4,4,5,5,6,6,7};
        System.out.print("Array Before Removing duplictaes: ");
        for(int i: arr){
            System.out.print(i+" ");
        }
        int newlength = removeDuplicate(arr);
        System.out.print("\nArray after Removing duplictaes: ");
        for(int i = 0;i<newlength;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("\nNew Length of the Array: "+newlength);
    }
}
