/*
L.C: 15. 3Sum

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 
Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    // Approach 1: Brute force
    // Time Complexity: O(n^3)*O(nlogn)
    // Space Complexity: 2*O(no. of triplets)

    public static List<List<Integer>> threeSum(int nums[]){
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0;i<n;i++){
            for(int j= i+1;j<n;j++){
                for(int k = j+1;k<n;k++){
                    if(nums[i]+nums[j]+nums[k] == 0){
                        List<Integer> list = Arrays.asList(nums[i],nums[j],nums[k]);
                        Collections.sort(list);
                        set.add(list);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    // Time Complexity: O(n^2)
    // Space Complexity: O(n)+O(no. of triplet)

    public static List<List<Integer>> threeSumI(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> list = new HashSet<>();
        for(int i = 0;i<n;i++){
            Set<Integer> set= new HashSet<>();
            for(int j = i+1;j<n;j++){
                int k = -(nums[i]+nums[j]);
                if(set.contains(k)){
                    List<Integer> temp = Arrays.asList(nums[i],nums[j],k);
                    Collections.sort(temp);
                    list.add(temp);
                }
                set.add(nums[j]);
            }
        }
        return new ArrayList<>(list);
    }

    // Time Complexity: O(nlogn)+O(n^2)
    // Space Complexity: O(no. of triplets)
    public static List<List<Integer>> threeSumII(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0;i<n;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = n-1;
            while(j < k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum < 0){
                    j++;
                }
                else if(sum > 0){
                    k--;
                }
                else{
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while(j<k && nums[j] == nums[j+1]) j++;
                    while(j<k && nums[k] == nums[k-1]) k--;
                    j++;
                    k--;
                }
            } 
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {-1,0,1,2,-1,-4};
        List<List<Integer>> ans = threeSum(arr);
        List<List<Integer>> ans1 = threeSumI(arr);
        List<List<Integer>> ans2 = threeSumII(arr);
        System.out.println(ans);
        System.out.println(ans1);
        System.out.println(ans2);
    }
}
