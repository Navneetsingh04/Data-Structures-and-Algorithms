/*
L.C: 215. Kth Largest Element in an Array

Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

Constraints:
1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104
*/
// Time complexity : O(nlogk)

import java.util.PriorityQueue;

public class KthLargestEelemet {
    public static int kthLargestEelemet(int arr[],int n,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0;i<k;i++){
            pq.add(arr[i]);
        }
        for(int i = k;i<n;i++){
            if(arr[i] > pq.peek()){
                pq.poll();
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    } 
    public static void main(String[] args) {
        int arr[] = {7,10,4,3,20,15};
        int size = arr.length;
        int k = 4;
        int ans = kthLargestEelemet(arr, size, k);
        System.out.println(k+"th Smallest Elemet is: "+ans);
    }
}
