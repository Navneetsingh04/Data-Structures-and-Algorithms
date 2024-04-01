/*
L.C: 540. Single Element in a Sorted Array

You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
Return the single element that appears only once.
Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10
*/
// Time complexity: O(logn)

public class OddOcurringElement {
    public static int oddOcurringElement(int arr[]){
        int n = arr.length;
        int s = 0;
        int end = n-1;
        while(s<=end){
            if(s==end){
                return s;
            }
            int mid = s+(end-s)/2;
            // mid check even or odd
            if((mid&1)==1){
                if(mid-1 >= s && arr[mid] == arr[mid-1]){
                    s = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
            else{
                if(mid+1 <= end && arr[mid]==arr[mid+1]){
                    s = mid+2;
                }
                else{
                    // we are at right part or at answer
                    end = mid;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1,1,5,5,2,2,3,3,5,4,4};
        int ans =  oddOcurringElement(arr);
        System.out.println("Odd occuring element is "+arr[ans]);
    }
}
