/*
L.C: 347. Top K Frequent Elements
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique. 
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static int[] topKFrequentElements(int nums[],int k){
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>(
            (a,b) -> a.getValue() - b.getValue()
        );
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            minHeap.offer(e);
            if(minHeap.size() > k){
                 minHeap.poll();
            }
        }
        int ans[] = new int[k];
        int index = 0;
        while(!minHeap.isEmpty()){
            ans[index++] = minHeap.poll().getKey();
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequentElements(nums, k)));
    }
}
