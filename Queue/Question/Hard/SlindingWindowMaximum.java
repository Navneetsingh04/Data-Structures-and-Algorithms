/*
L.C: 239. Sliding Window Maximum

You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
Return the max sliding window.

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]

Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length 
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class SlindingWindowMaximum {
    public static int[] maxSlidingWindow(int arr[],int k){
        int n = arr.length;
        if(n == 0){
            return new int[0];
        }
        int ans[] = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0;i<n;i++){
            // removing element from the current window
            if(!dq.isEmpty() && dq.peekFirst()<i-k+1){
                dq.pollFirst();
            }
            // Removing elemnts smaller than the current element
            while(!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]){
                dq.pollLast();
            }
            // Adding the current element at the rear
            dq.addLast(i);
            if(i >= k-1){
                ans[i-k+1] = arr[dq.peekFirst()];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int ans[] = maxSlidingWindow(arr, k);
        System.out.print("Sliding Window maximum : ");
        for(int i : ans){
            System.out.print(i+" ");
        }
    }
}
