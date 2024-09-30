/*
L.C: 152. Maximum Product Subarray

Given an integer array nums, find a 
subarray that has the largest product, and return the product.
The test cases are generated so that the answer will fit in a 32-bit integer.

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any subarray of nums is guaranteed to fit in a 32-bit integer.
*/
// Time Compexity: O(n)
// Spaxe Complexity: O(1)
public class MaximumProductSum {
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int mini = nums[0],maxi = nums[0],ans = nums[0];
        for(int i = 1;i<n;i++){
            if(nums[i] < 0){
                int temp = maxi;
                maxi = mini;
                mini = temp;
            }
            maxi = Math.max(nums[i],maxi*nums[i]);
            mini = Math.min(nums[i],mini*nums[i]);
            ans = Math.max(ans,maxi);
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {2,3,-2,4};
        System.out.println(maxProduct(arr));
    }
}
