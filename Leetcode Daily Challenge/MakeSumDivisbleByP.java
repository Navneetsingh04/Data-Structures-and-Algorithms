/*
L.C: 1590. Make Sum Divisible by P

Given an array of positive integers nums, remove the smallest subarray (possibly empty) such that the sum of the remaining elements is divisible by p. It is not allowed to remove the whole array.

Return the length of the smallest subarray that you need to remove, or -1 if it's impossible.

A subarray is defined as a contiguous block of elements in the array.

 

Example 1:

Input: nums = [3,1,4,2], p = 6
Output: 1
Explanation: The sum of the elements in nums is 10, which is not divisible by 6. We can remove the subarray [4], and the sum of the remaining elements is 6, which is divisible by 6.
Example 2:

Input: nums = [6,3,5,2], p = 9
Output: 2
Explanation: We cannot remove a single element to get a sum divisible by 9. The best way is to remove the subarray [5,2], leaving us with [6,3] with sum 9.
Example 3:

Input: nums = [1,2,3], p = 3
Output: 0
Explanation: Here the sum is 6. which is already divisible by 3. Thus we do not need to remove anything.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109
1 <= p <= 109 
*/
import java.util.HashMap;
import java.util.Map;

public class MakeSumDivisbleByP {
      public static int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int sum = 0;
        for(int i : nums){
            sum = (sum + i)%p;
        }
        int target = sum%p;
        if(target == 0){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        int curr = 0;
        map.put(0,-1);
        int result = n;

        for(int j = 0;j<n;j++){
            curr = (curr+nums[j])%p;
            int find = (curr - target+p)%p;
            if(map.containsKey(find)){
                result = Math.min(result,j-map.get(find));
            }
            map.put(curr,j);
        }
        return result == n ? -1: result;
    }
    public static void main(String[] args) {
        int nums[] = {3,1,4,2};
        int p = 6;
        System.out.println(minSubarray(nums, p));
    }
}
