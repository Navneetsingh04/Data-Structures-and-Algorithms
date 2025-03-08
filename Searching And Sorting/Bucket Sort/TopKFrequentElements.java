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
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class TopKFrequentElements {
    public static int[] topKFrequentElements(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[k];
        int index = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<Integer>[] list = new List[n+1];
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            int freq = e.getValue();
            if(list[freq] == null){
                list[freq] = new ArrayList<>();
            }
            list[freq].add(e.getKey());
        }
        for(int i = list.length-1;i>0 && index<k;i--){
            if(list[i] != null){
                for(int num : list[i]){
                    ans[index++] = num;
                    if(index == k){
                        break;
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequentElements(nums, k)));
    }
}
