/*
L.C: 2873. Maximum Value of an Ordered Triplet I

You are given a 0-indexed integer array nums.

Return the maximum value over all triplets of indices (i, j, k) such that i < j < k. If all such triplets have a negative value, return 0.
The value of a triplet of indices (i, j, k) is equal to (nums[i] - nums[j]) * nums[k].

Example 1:
Input: nums = [12,6,1,2,7]
Output: 77
Explanation: The value of the triplet (0, 2, 4) is (nums[0] - nums[2]) * nums[4] = 77.
It can be shown that there are no ordered triplets of indices with a value greater than 77. 

Example 2:
Input: nums = [1,10,3,4,19]
Output: 133
Explanation: The value of the triplet (1, 2, 4) is (nums[1] - nums[2]) * nums[4] = 133.
It can be shown that there are no ordered triplets of indices with a value greater than 133.

Example 3:
Input: nums = [1,2,3]
Output: 0
Explanation: The only ordered triplet of indices (0, 1, 2) has a negative value of (nums[0] - nums[1]) * nums[2] = -3. Hence, the answer would be 0.
 
Constraints:
3 <= nums.length <= 100
1 <= nums[i] <= 106 
*/
public class MaximumValueOfOrderedTripletI {

    // Time Complexity: O(n^3)
    // Space Complexity: O(1)

    public static long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxi = Integer.MIN_VALUE;
        if(n<3) return 0;
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                for(int k = j+1;k<n;k++){
                    long sum = (long)(nums[i]-nums[j])*nums[k];
                    maxi = Math.max(sum,maxi);
                }
            }
        }
        return Math.max(maxi,0);
    }
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public static long maximumTripletValueI(int[] nums) {
        int n = nums.length;
        long maxi = 0;
        if(n<3) return 0;
        for(int k = 2;k<n;k++){
            int maxPrefix = nums[0];
            for(int j = 1;j<k;j++){
                long res = (long)(maxPrefix-nums[j])*nums[k];
                maxi = Math.max(maxi,res);
                maxPrefix = Math.max(maxPrefix,nums[j]);
            }
        }
        return maxi;
    }
    public static void main(String[] args) {
        
    }
}
