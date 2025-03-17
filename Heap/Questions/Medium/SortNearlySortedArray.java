/*
L.C: Nearly sorted

Given an array arr[], where each element is at most k away from its target position, you need to sort the array optimally.
Note: You need to change the given array arr[] in place.

Examples:

Input: arr[] = [6, 5, 3, 2, 8, 10, 9], k = 3
Output: [2, 3, 5, 6, 8, 9, 10]
Explanation: The sorted array will be 2 3 5 6 8 9 10
Input: arr[]= [1, 4, 5, 2, 3, 6, 7, 8, 9, 10], k = 2
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Explanation: The sorted array will be 1 2 3 4 5 6 7 8 9 10
Don't use the inbuilt sort() function for this question.

Constraints:
1 ≤ arr.size() ≤ 106
0 ≤ k < arr.size()
1 ≤ arri ≤ 106 
*/

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortNearlySortedArray {
    public static void nearlySorted(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int index = 0;
        for(int i = 0;i<arr.length;i++){
            minHeap.add(arr[i]);
            if(minHeap.size() > k){
                arr[index++] = minHeap.poll();
            }
        }
        while(!minHeap.isEmpty()){
            arr[index++] = minHeap.poll();
        }
    }
    public static void main(String[] args) {
        int arr[] = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;
        nearlySorted(arr, k);
        System.out.println(Arrays.toString(arr));
    }
}
