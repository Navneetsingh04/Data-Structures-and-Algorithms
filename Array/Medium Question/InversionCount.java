/*
GFG: Count Inversions

Given an array of integers. Find the Inversion Count in the array.  Two elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i < j.

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If the array is already sorted then the inversion count is 0.
If an array is sorted in the reverse order then the inversion count is the maximum. 

Examples:

Input: arr[] = {2, 4, 1, 3, 5}
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
Input: arr[] = {2, 3, 4, 5, 6}
Output: 0
Explanation: As the sequence is already sorted so there is no inversion count.
Input: arr[] = {10, 10, 10}
Output: 0
Explanation: As all the elements of array are same, so there is no inversion count.

Constraints:
1 ≤ arr.size(),arr[i] ≤ 105 
*/

import java.util.ArrayList;

public class InversionCount {
    // Time Complexity: O(n*logn)
    // Space Complexity: O(n)
    public static int merg(long arr[],int low,int high,int mid){
        int i = low;
        int j = mid+1;
        int count = 0;
        ArrayList<Long> temp = new ArrayList<>();
        while(i <= mid && j <= high){
            if(arr[i] <= arr[j]){
                temp.add(arr[i]);
                i++;
            }
            else{
                temp.add(arr[j]);
                count += (mid-i+1);
                j++;
            }
        }
        while(i <= mid){
            temp.add(arr[i]);
            i++;
        }
        while(j <= high){
            temp.add(arr[j]);
            j++;
        }
        for (int l = low; l <= high; l++) {
            arr[l] = temp.get(l-low);
        }
        return count;
    }
    public static int mergSort(long arr[],int low,int high){
        int count = 0;
        if(low >= high) return count;
        int mid = low+(high-low)/2;
        count += mergSort(arr,low,mid);
        count +=mergSort(arr,mid+1,high);
        count +=merg(arr,low,high,mid);
        return count;
    }
    public static long inversionCount(long arr[]) {
        int n = arr.length;
        return mergSort(arr,0,n-1);
    }
    public static void main(String[] args) {
        long arr[] = {2, 4, 1, 3, 5};
        System.out.println("Total Inversion count : "+inversionCount(arr));
    }
}
