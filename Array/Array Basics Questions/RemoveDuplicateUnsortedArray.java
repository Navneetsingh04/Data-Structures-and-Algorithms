/*
You are given a unsorted array. Your task is to implement a function that removes duplicate elements from the array in-place. The resulting array should have each element appearing only once, and the order of elements should be preserved.
Input: 
arr: A sorted list of integers. (0 <= len(arr) <= 10^5)
Output: 
Return an integer representing the new length of the array after removing duplicates.
Constraints:

The given array is Unsorted.
The removal of duplicates must be done in-place, i.e., you're not allowed to use another data structure to temporarily store elements.
The order of elements must be preserved.
*/
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class RemoveDuplicateUnsortedArray {
    // Approach 1
    // Time Complexity: O(nlogn)
    // Space Complexity: O(1)

    public static int removeDuplicate(int arr[]){
        if(arr.length == 0){
            return 0;
        }
        Arrays.sort(arr);
        int index = 1;
        for(int i = 1;i<arr.length;i++){
            if(arr[i] != arr[index-1]){
                arr[index] = arr[i];
                index++;
            }
        }
        return index;
    }
    // Approach 2
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static int removeDuplicateI(int arr[]){
        int n = arr.length;
        if(n == 0) return 0;
        int index = 0;

        for(int i = 0;i<n;i++){
            boolean isDuplicate = false;
            for(int j = 0;j<i;j++){
                if(arr[i] == arr[j]){
                    isDuplicate = true;
                    break;
                }
            }
            if(!isDuplicate){
                arr[index++] = arr[i];
            }
        }
        return index;
    }

    // Approach 3: using HashSet
    // Time Complexity: O(n)
    // Space Complexity: O(1)

    public static int removeDuplicateII(int arr[]){
        int n = arr.length;
        if(n == 0) return 0;
        Set<Integer> set = new HashSet<>();

        for(int i: arr){
            set.add(i);
        }
        int index = 0;
        for(Object i: set){
            arr[index++] = (int)i;
        }
        return index;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{13,1,1,8,2,3,13,4,4,5,5,6,6,7,8};
        System.out.print("Array Before Removing duplictaes: ");
        for(int i: arr){
            System.out.print(i+" ");
        }
        // int newlength = removeDuplicate(arr);
        // int newlength = removeDuplicateII(arr);
        int newlength = removeDuplicateI(arr);
        System.out.print("\nArray after Removing duplictaes: ");
        for(int i = 0;i<newlength;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("\nNew Length of the Array: "+newlength);
    }
}

