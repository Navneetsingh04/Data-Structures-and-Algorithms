/*
L.C: 1695. Maximum Erasure Value

You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.
Return the maximum score you can get by erasing exactly one subarray.
An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).

Example 1:

Input: nums = [4,2,4,5,6]
Output: 17
Explanation: The optimal subarray here is [2,4,5,6].

Example 2:
Input: nums = [5,2,1,2,5,2,1,2,5]
Output: 8
Explanation: The optimal subarray here is [5,2,1] or [1,2,5].
 
Constraints:
1 <= nums.length <= 105
1 <= nums[i] <= 104 
*/

import java.util.HashSet;
import java.util.Set;

public class MaxErasureValue {

    // Approach 1: Brute Force
    // Time Complexity : O(n^2)
    // space Complexity : O(n)
    public static int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int maxScore = Integer.MIN_VALUE;
        
        for(int i= 0;i<n;i++){
            Set<Integer> set = new HashSet<>();
            int currSum = 0;
            for(int j = i;j<n;j++){
                if(set.contains(nums[j])){
                    break;
                }
                set.add(nums[j]);
                currSum += nums[j];
                maxScore = Math.max(maxScore,currSum);
            }  
        }
        return maxScore;
    }

    // Approach 2: Sliding Window 
    // Time Complexity : O(n)
    // space Complexity : O(n)
    public static int maximumUniqueSubarrayI(int[] nums){
        int n = nums.length;
        Set<Integer> set  = new HashSet<>();
        int i = 0,maxScore = 0, sum = 0;

        for(int j = 0;j<n;j++){
            while(set.contains(nums[j])){
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }
            set.add(nums[j]);
            sum += nums[j];
            maxScore = Math.max(maxScore,sum);
        }
        return maxScore;
    }
    public static void main(String[] args) {
        int nums[] = {4,2,4,5,6};
        System.out.println(maximumUniqueSubarrayI(nums));
    }
}
