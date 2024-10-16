/*
L.C: 229. Majority Element II

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
Example 1:
Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]
 

Constraints:

1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109 
*/

// import java.util.ArrayList;
// import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
// import java.util.Map;

public class MajorityElementII {
    // Approach 1: Hashing
    // time Complexity: O(nlogn)
    // Space Compexity: O(n)
    // public static List<Integer> majorityElement(int[] nums) {
    //     int n = nums.length;
    //     List<Integer> ans = new ArrayList<>();
    //     if(n == 1){
    //         ans.add(nums[0]);
    //         return ans;
    //     }
    //     Map<Integer,Integer> map = new HashMap<>();
    //     for(int i = 0;i<n;i++){
    //         map.put(nums[i],map.getOrDefault(nums[i],0)+1);
    //     }
    //     for(Map.Entry<Integer,Integer> en : map.entrySet()){
    //         if(en.getValue() > nums.length/3){
    //             ans.add(en.getKey());
    //         }
    //     }
    //     return ans;
    // }

    // Approach 1: Moore's Voting Algorithm
    // time Complexity: O(n)
    // Space Compexity: O(n)
    public static List<Integer> majorityElement(int[] nums){
        int count1 = 0,count2 = 0;
        int ele1 = Integer.MIN_VALUE,ele2 =Integer.MIN_VALUE;
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<n-1;i++){
            if(count1 == 0 && ele2 != nums[i]){
                count1 = 1;
                ele1 = nums[i];
            }
            else if(count2 == 0 && ele1 != nums[i]){
                count2 = 1;
                ele2 = nums[i];
            }
            else if(ele1 == nums[i]) count1++;
            else if(ele2 == nums[i]) count2++;
            else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int i = 0;i<n;i++){
            if(ele1 == nums[i]) count1++;
            if(ele2 == nums[i]) count2++;
        }
        int min = (int)(n/3)+1;
        if(count1 >= min) ans.add(ele1);
        if(count2 >= min) ans.add(ele2);
        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {1,4,5,5,4,4,4,5,5,8,9};
        List<Integer> ans = majorityElement(nums);
        System.out.println(ans);
    }
}
