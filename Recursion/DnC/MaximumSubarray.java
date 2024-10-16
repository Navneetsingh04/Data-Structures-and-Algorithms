/*
L.C: 53. Maximum Subarray

Given an integer array nums, find the 
subarray
with the largest sum, and return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 
Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
 */
public class MaximumSubarray {
    public static int maxSubArrayHelpher(int arr[],int start,int end){
        if(start == end){
            return arr[start];
        }
        int maxLeftBorderSum = Integer.MIN_VALUE;
        int maxRightBorderSum = Integer.MIN_VALUE;
        int leftBorderSum = 0;
        int rightBorderSum = 0;
        int mid = start+(end-start)/2;
        int maxLeftSum = maxSubArrayHelpher(arr, start, mid);
        int maxRightSum = maxSubArrayHelpher(arr, mid+1, end);
        for(int i = mid;i>= start;i--){
            leftBorderSum += arr[i];
            if(leftBorderSum >= maxLeftBorderSum){
                maxLeftBorderSum = leftBorderSum;
            }
        }
        for(int i = mid+1;i<=end;i++){
            rightBorderSum += arr[i];
            if(rightBorderSum >= maxRightBorderSum){
                maxRightBorderSum = rightBorderSum;
            }
        }
        int crossBorderSum = maxLeftBorderSum+maxRightBorderSum;
        return Math.max(crossBorderSum,Math.max(maxRightSum,maxLeftSum));
    }
    public static int maxSubArray(int arr[]){
        return maxSubArrayHelpher(arr,0,arr.length);
    }
    public static void main(String args[]){
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("maximum SubArray sum: "+maxSubArray(arr));
    }
}
