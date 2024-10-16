/*
L.C: 53. Maximum Subarray

Given an integer array nums, find the 
subarray with the largest sum, and return its sum.
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
    // Approach 1 
    // Time Complexity :  O(n^3)

    // public static int maximumSubarray(int arr[]){
    //     int n = arr.length;
    //     int maxi = Integer.MIN_VALUE;
    //     for(int i = 0;i<n;i++){
    //         for(int j = i;j<n;j++){
    //             int sum = 0;
    //             for(int k = i;k<=j;k++){
    //                 sum += arr[k];
    //                 maxi = Math.max(maxi,sum);
    //             }
    //         }  
    //     }
    //     return maxi;
    // }
    
    // Approach 2 
    // Time Complexity :  O(n^2)
    // public static int maximumSubarray(int arr[]){
    //     int n = arr.length;
    //     int maxi = Integer.MIN_VALUE;
    //     for(int i = 0;i<n;i++){
    //         int sum = 0;
    //         for(int j = i;j<n;j++){
    //             sum += arr[j];
    //             maxi = Math.max(maxi,sum);
    //         }  
    //     }
    //     return maxi;
    // }

    // Approach 3: Kadane's Algorithm 
    // Time Complexity :  O(n)
    public static int maximumSubarray(int arr[]){
        int n = arr.length;
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0;i<n;i++){
            sum += arr[i];
            if(sum>maxi){
                maxi = sum;
            }
            if(sum<0){
                sum = 0;
            }
        }
        return maxi;
    }
    public static void main(String[] args) {
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("maximum Sum is: "+ maximumSubarray(arr));
    }
}
