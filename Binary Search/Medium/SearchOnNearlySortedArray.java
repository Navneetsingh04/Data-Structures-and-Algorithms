/*
Given a sorted array arr[] of size N, some elements of array are moved to either of the adjacent positions, i.e., arr[i] may be present at arr[i+1] or arr[i-1] i.e. arr[i] can only be swapped with either arr[i+1] or arr[i-1]. The task is to search for an element in this array.

Examples : 

Input: arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 40
Output: 2 
Explanation: Output is index of 40 in given array i.e. 2

Input: arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 90
Output: -1
Explanation: -1 is returned to indicate the element is not present

*/
// Time complexity : O(logn)

public class SearchOnNearlySortedArray {
    public static int searchOnNearlySortedArray(int arr[],int target){
        int n = arr.length;
        int s = 0;
        int end = n-1;
        while(s<=end){
            int mid = s+(end-s)/2;
            if(mid-1 >= s && arr[mid-1] == target){
                return mid-1;
            }
            if(arr[mid] == target){
                return mid;
            }
            if(mid+1 <= end && arr[mid+1] == target){
                return mid+1;
            }
            else if(arr[mid] < target){
                s = mid+2;
            }
            else{
                end = mid-2;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        int arr[] = new int[]{20,10,30,50,40,70,60};
        int target = 20;
        int ans = searchOnNearlySortedArray(arr, target);
        if(ans== -1){
            System.out.println("target not found");
        }
        else{
            System.out.println("target found at "+ ans+" index");
        }
    }
}