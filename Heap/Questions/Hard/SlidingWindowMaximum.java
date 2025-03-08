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

import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    static class Pair implements Comparable<Pair>{
        int val;
        int index;
        Pair(int val,int index){
            this.val = val;
            this.index = index;
        }
        public int compareTo(Pair o){
            return Integer.compare(o.val,this.val);
        }
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int ans[] = new int[nums.length-k+1];
        for(int i = 0;i<k;i++){
            pq.add(new Pair(nums[i],i));
        }
        ans[0] = pq.peek().val;
        // consider rest of window
        for(int i = k;i<nums.length;i++){
            pq.add(new Pair(nums[i],i));
            // remove if max is from previous window
            while(pq.peek().index <= i-k){
                pq.poll();
            }
            ans[i-k+1] = pq.peek().val;
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int ans[] = maxSlidingWindow(arr, k);
        for(int i: ans){
            System.out.print(i+" ");
        }
    }
}
