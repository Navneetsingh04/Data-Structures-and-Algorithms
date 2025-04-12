/*
L.C: 2780. Minimum Index of a Valid Split

An element x of an integer array arr of length m is dominant if more than half the elements of arr have a value of x.

You are given a 0-indexed integer array nums of length n with one dominant element.

You can split nums at an index i into two arrays nums[0, ..., i] and nums[i + 1, ..., n - 1], but the split is only valid if: 0 <= i < n - 1
nums[0, ..., i], and nums[i + 1, ..., n - 1] have the same dominant element.
Here, nums[i, ..., j] denotes the subarray of nums starting at index i and ending at index j, both ends being inclusive. Particularly, if j < i then nums[i, ..., j] denotes an empty subarray.

Return the minimum index of a valid split. If no valid split exists, return -1.

Example 1:
Input: nums = [1,2,2,2]
Output: 2
Explanation: We can split the array at index 2 to obtain arrays [1,2,2] and [2]. 
In array [1,2,2], element 2 is dominant since it occurs twice in the array and 2 * 2 > 3. 
In array [2], element 2 is dominant since it occurs once in the array and 1 * 2 > 1.
Both [1,2,2] and [2] have the same dominant element as nums, so this is a valid split. 
It can be shown that index 2 is the minimum index of a valid split. 

Example 2:
Input: nums = [2,1,3,1,1,1,7,1,2,1]
Output: 4
Explanation: We can split the array at index 4 to obtain arrays [2,1,3,1,1] and [1,7,1,2,1].
In array [2,1,3,1,1], element 1 is dominant since it occurs thrice in the array and 3 * 2 > 5.
In array [1,7,1,2,1], element 1 is dominant since it occurs thrice in the array and 3 * 2 > 5.
Both [2,1,3,1,1] and [1,7,1,2,1] have the same dominant element as nums, so this is a valid split.
It can be shown that index 4 is the minimum index of a valid split.

Example 3:
Input: nums = [3,3,3,3,7,2,2]
Output: -1
Explanation: It can be shown that there is no valid split.
 
Constraints:
1 <= nums.length <= 105
1 <= nums[i] <= 109
nums has exactly one dominant element.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexOfValidSplit {
    public static int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();

        for(int i : nums){
            map2.put(i,map2.getOrDefault(i,0)+1);
        }
        for(int i = 0;i<n;i++){
            int num = nums.get(i);

            map1.put(num,map1.getOrDefault(num,0)+1);
            map2.put(num,map2.get(num)-1);

            int n1 = i+1;
            int n2 = n-i-1;

            if(map1.get(num)*2 > n1 && map2.get(num)*2 > n2){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Integer arr[] = {2,1,3,1,1,1,7,1,2,1};
        List<Integer> nums = new ArrayList<>(Arrays.asList(arr));
        System.out.println(minimumIndex(nums));
    }
}
