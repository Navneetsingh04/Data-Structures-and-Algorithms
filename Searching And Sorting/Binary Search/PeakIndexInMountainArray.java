/*
L.C: 852. Peak Index in a Mountain Array
An array arr is a mountain if the following properties hold:
arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].

You must solve it in O(log(arr.length)) time complexity.

Example 1:

Input: arr = [0,1,0]
Output: 1
Example 2:

Input: arr = [0,2,1,0]
Output: 1
Example 3:

Input: arr = [0,10,5,2]
Output: 1

Constraints:

3 <= arr.length <= 105
0 <= arr[i] <= 106
arr is guaranteed to be a mountain array.
 */

//  Time complexity : O(logn)
public class PeakIndexInMountainArray {
    public static int peakIndexInMountainArray(int arr[]){
        int n = arr.length;
        int start = 0;
        int end = n-1;
        while(start<end){
            int mid = start+(end-start)/2;
            if(arr[mid]<arr[mid+1]){
                // we are in A line
                // peak exit in right
                start = mid+1;
            }
            else{
                // we are in B line or at peak element
                end = mid;
            }
        }
        return start;
    }
    public static void main(String[] args) {
        int arr[] =  new int[]{10,20,50,40,30};
        int result = peakIndexInMountainArray(arr);
        System.out.println("Peak element is at index  "+result);
    }
}
