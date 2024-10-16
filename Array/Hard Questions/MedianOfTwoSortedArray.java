/*
L.C: 4. Median of Two Sorted Arrays

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106 
*/
public class MedianOfTwoSortedArray {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int l = 0;
        int h = 0;
        int arr[] = new int[n+m];
        int index = 0;
        while(l < n && h < m){
            if(nums1[l] < nums2[h]){
                arr[index++] = nums1[l++];
            }
            else{
                arr[index++] = nums2[h++];
            }
        }
        while(l < n){
            arr[index++] = nums1[l++];
        }
        while(h < m){
            arr[index++] = nums2[h++];
        }

        int size = arr.length;
        int mid = size/2;
        if((size&1) == 1){
            return (double)arr[mid];
        }
        return (arr[mid-1]+arr[mid])/2.0;
    }
    public static void main(String[] args) {
        int nums1[] = {1,2};
        int nums2[] = {3,4};
        System.out.println("Medain of sorted array is: "+findMedianSortedArrays(nums1, nums2));
    }
}
