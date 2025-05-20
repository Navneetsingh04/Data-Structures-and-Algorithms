/*
Q3. Maximum Frequency After Subarray Operation

You are given an array nums of length n. You are also given an integer k.
You perform the following operation on nums once:

Select a subarraynums[i..j] where 0 <= i <= j <= n - 1.
Select an integer x and add x to all the elements in nums[i..j].
Find the maximum frequency of the value k after the operation.

Example 1:
Input: nums = [1,2,3,4,5,6], k = 1
Output: 2
Explanation:
After adding -5 to nums[2..5], 1 has a frequency of 2 in [1, 2, -2, -1, 0, 1].

Example 2:
Input: nums = [10,2,3,4,5,5,4,3,2,2], k = 10
Output: 4
Explanation:
After adding 8 to nums[1..9], 10 has a frequency of 4 in [10, 10, 11, 12, 13, 13, 12, 11, 10, 10].

Constraints:
1 <= n == nums.length <= 105
1 <= nums[i] <= 50
1 <= k <= 50 
*/
public class MaximumFreqAfterSubarrayOperation {
    public static int maxFrequency(int[] nums, int k) {
        int total = 0;
        for(int num : nums){
            if(num==k){
                total++;
            }
        }
        int max = 0;
        for(int i = 1;i<=50;i++){
            if(i==k) continue;
            int currSum = 0;
            int localMax = 0;
            for(int num : nums){
                if(num == i){
                    currSum += 1;
                }
                else if(num==k){
                    currSum -= 1;
                }
                if(currSum < 0){
                    currSum = 0;
                }
                if(currSum >localMax){
                    localMax  = currSum;
                }
            }
            if(localMax >max){
                max = localMax;
            }
        }
        return total+max;
    }
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6};
        int k = 1;
        System.out.println(maxFrequency(nums, k));
    }    
}
