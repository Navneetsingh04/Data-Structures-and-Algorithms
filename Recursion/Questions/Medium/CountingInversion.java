/*
GFG: Count Inversions

Given an array of integers. Find the Inversion Count in the array.  Two elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i < j.

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If the array is already sorted then the inversion count is 0.
If an array is sorted in the reverse order then the inversion count is the maximum. 

Examples:

Input: arr[] = [2, 4, 1, 3, 5]
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
Input: arr[] = [2, 3, 4, 5, 6]
Output: 0
Explanation: As the sequence is already sorted so there is no inversion count.
Input: arr[] = [10, 10, 10]
Output: 0
Explanation: As all the elements of array are same, so there is no inversion count.
Expected Time Complexity: O(n*logn).
Expected Auxiliary Space: O(n).

Constraints:
1 ≤ arr.size(),arr[i] ≤ 105
 */
public class CountingInversion {
    // public static int countInversion(int arr[]){
    //     int count = 0;
    //     for(int i = 0;i<arr.length;i++){
    //         for(int j = i+1;j<arr.length;j++){
    //             if(arr[i]>arr[j]){
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;
    // }
    public static int merg(int arr[],int temp[],int start,int end,int mid){
        int i = start;
        int j = mid+1;
        int k = start;
        int count = 0;
        while(i<=mid && j<=end){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }
            else{
                // inversion count
                temp[k++] = arr[j++];
                count += (mid-i+1);
            }
        }
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        while(j<= end){
            temp[k++] = arr[j++];
        }
        while(start <= end){
            arr[start] = temp[start];
            start++;
        }
        return count;
    }
    public static int mergSort(int arr[],int temp[],int start,int end){
        int count = 0;
        if(start<end){
            int mid = start+(end-start)/2;
            count += mergSort(arr, temp, start, mid);
            count += mergSort(arr, temp, mid+1, end);
            count += merg(arr,temp,start,end,mid);
        }
        return count;
    }
    public static int countInversion(int arr[]){
        int temp[] = new int[arr.length];
        return mergSort(arr,temp,0,arr.length-1);
    }
    public static void main(String[] args) {
        int arr[] = new int[]{2,4,1};
        System.out.println(countInversion(arr));
    }
}
