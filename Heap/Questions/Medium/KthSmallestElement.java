/* 
Kth Smallest Element in Unsorted Array

Given an array arr[] of N distinct elements and a number K, where K is smaller than the size of the array. Find the K’th smallest element in the given array.

Examples:

Input: arr[] = {7, 10, 4, 3, 20, 15}, K = 3 
Output: 7

Input: arr[] = {7, 10, 4, 3, 20, 15}, K = 4 
Output: 10  
*/

// Time complexity : O(nlogk)
import java.util.Collections;
import java.util.PriorityQueue;
public class KthSmallestElement {
    public static int kthSmallestElement(int arr[],int size,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // Processing first k element
        for(int i = 0;i<k;i++){
            pq.add(arr[i]);
        }
        // we insert remaining elements only if they are samaller than root element
        for(int i = k;i<size;i++){
            if(arr[i] < pq.peek()){
                // Removing top element
                pq.poll();
                // add the smallest element
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    }
    public static void main(String[] args) {
        int arr[] = {7,10,4,3,20,15};
        int size = arr.length;
        int k = 4;
        int ans = kthSmallestElement(arr, size, k);
        System.out.println(k+"th Smallest element is: "+ans);
    }
}
