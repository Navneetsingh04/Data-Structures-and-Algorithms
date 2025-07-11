// Time Complexity: O(n + k) where k = max element
// Space Complexity: O(k+n) for the count and output array

public class CountingSort {
    public static void countingSort(int arr[]){
        int n = arr.length;

        // Find the max element
        int max = arr[0];
        for(int i = 1;i<n;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        // Create count array and find the freq of elements in the original array
        int count[] = new int[max+1];
        for(int i : arr){
            count[i]++;
        }

        // modifies the count arry (prefix Sum)

        for(int i = 1;i<=max;i++){
            count[i] += count[i-1];
        }

        // Build the Output Array 
        // Iterate from end to start of input array for stability. 
        // Use count[] to place each element at its correct position.

        int output[] = new int[n];
        for(int i = n-1;i>=0;i--){
            output[count[arr[i]]-1] = arr[i];
            count[arr[i]]--;  // ensures next duplicate goes one position before
        }

        // copy output to original array

        for(int i= 0;i<n;i++){
            arr[i] = output[i];
        }
    }
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        System.out.print("Before Sorting: ");
        for(int num : arr){
            System.out.print(num + " ");
        }
        countingSort(arr);
        System.out.print("\nAfter Sorting: ");
        for(int num : arr){
            System.out.print(num + " ");
        }
    }
}
