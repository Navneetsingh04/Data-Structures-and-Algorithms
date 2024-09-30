/*
L.C 643. Maximum Average Subarray I
You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

Example 1:

Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
Example 2:

Input: nums = [5], k = 1
Output: 5.00000
Constraints:

n == nums.length
1 <= k <= n <= 105
-104 <= nums[i] <= 104
 */

//  1st Approach: Sliding window
// Time complexity: O(n)
// space complexity : O(1)
// public class MaximumAvgSubarray {
//     public static double maximumAvgSubarray(int arr[], int k) {
//         int maxSum = Integer.MIN_VALUE;
//         int sum = 0;
        
//         // sum of first k elements
//         for (int i = 0; i < k; i++) {
//             sum += arr[i];
//         }
//         maxSum = sum;
//         // Slide the window
//         for (int i = k; i < arr.length; i++) {
//             sum += arr[i] - arr[i - k];
//             maxSum = Math.max(maxSum, sum);
//         }
        
//         return (double) maxSum / k;
//     }
//     public static void main(String[] args) {
//         int arr[] = new int[]{1, 12, -5, -6, 50, 3};
//         double result = maximumAvgSubarray(arr, 4);
//         System.out.println(result);
//     }
// }

public class MaximumAvgSubarray {
    public static double maximumAvgSubarray(int arr[], int k){
        int i = 0,j = k-1;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int x = i;x<=j;x++){
            sum += arr[x];
        }
        maxSum = sum;
        while(j<arr.length-1){
            sum -= arr[i++];
            sum += arr[++j];
            maxSum = Math.max(maxSum, sum);
        }
        double avgSum = (double) maxSum/k;
        return avgSum;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1, 12, -5, -6, 50, 3};
        double result = maximumAvgSubarray(arr, 4);
        System.out.println(result);
        }
}