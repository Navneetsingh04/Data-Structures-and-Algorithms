/*
L.C: 368. Largest Divisible Subset

Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:

answer[i] % answer[j] == 0, or
answer[j] % answer[i] == 0
If there are multiple solutions, return any of them.

Example 1:
Input: nums = [1,2,3]
Output: [1,2]
Explanation: [1,3] is also accepted.

Example 2:
Input: nums = [1,2,4,8]
Output: [1,2,4,8]
 
Constraints:
1 <= nums.length <= 1000
1 <= nums[i] <= 2 * 109
All the integers in nums are unique. 
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int dp[] = new int[n];
        int hash[] = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(hash,-1);
        int idx = 0, maxSize = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<i;j++){
                if(nums[i]%nums[j] == 0 && dp[j]+1 > dp[i]){
                    dp[i] = dp[i]+1;
                    hash[i] = j;
                }
            }
            if(dp[i] > maxSize){
                maxSize = dp[i];
                idx = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        while(idx != -1){
            list.add(nums[idx]);
            idx = hash[idx];
        }
        return list;
    }
    public static void main(String[] args) {
        int nums[] = {1,16,7,4,8};
        System.out.println(largestDivisibleSubset(nums));
    }
}
