/*
3254. Find the Power of K-Size Subarrays I

You are given an array of integers nums of length n and a positive integer k.
The power of an array is defined as:
Its maximum element if all of its elements are consecutive and sorted in ascending order.
-1 otherwise.
You need to find the power of all subarrays of nums of size k.
Return an integer array results of size n - k + 1, where results[i] is the power of nums[i..(i + k - 1)].

Example 1:
Input: nums = [1,2,3,4,3,2,5], k = 3
Output: [3,4,-1,-1,-1]
Explanation:
There are 5 subarrays of nums of size 3:
[1, 2, 3] with the maximum element 3.
[2, 3, 4] with the maximum element 4.
[3, 4, 3] whose elements are not consecutive.
[4, 3, 2] whose elements are not sorted.
[3, 2, 5] whose elements are not consecutive.

Example 2:
Input: nums = [2,2,2,2,2], k = 4
Output: [-1,-1]

Example 3:
Input: nums = [3,2,3,2,3,2], k = 2
Output: [-1,3,-1,3,-1]

Constraints:
1 <= n == nums.length <= 500
1 <= nums[i] <= 105
1 <= k <= n
*/

import java.util.Arrays;

public class FindThePowerofKSizeSubarray {
    // Time Complexity: O(N*K)

    // public static int[] resultArray(int nums[],int k){
    //     int n = nums.length;
    //     int ans[] = new int[n-k+1];
    //     for(int i = 0;i<=n-k;i++){
    //         boolean isSorted  = true;
    //         for(int j = i;j<i+k-1;j++){
    //             if(nums[j+1] != nums[j]+1){
    //                 isSorted = false;
    //                 break;
    //             }
    //         }
    //         if(isSorted){
    //             ans[i] = nums[i+k-1];
    //         }
    //         else{
    //             ans[i] = -1;
    //         }
    //     }
    //     return ans;
    // }

    public static int[] resultArray(int nums[],int k){
        int n = nums.length;
        int ans[] = new int[n-k+1];
        Arrays.fill(ans, -1);
        int count = 1;
        for(int i = 1;i<k;i++){
            if(nums[i] == nums[i-1]+1){
                count++;
            }
            else{
                count = 1;
            }
        }
        if(count == k){
            ans[0] = nums[k-1];
        }
        int i = 1;
        int j = k;
        while(j<n){
            if(nums[j] == nums[j-1]+1){
                count++;
            }
            else{
                count = 1;
            }
            if(count >= k){
                ans[i] = nums[j];
            }
            i++;
            j++;
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3,2,5,6,7};
        int k = 3;
        int ans[] = resultArray(arr, k);
        System.out.println(Arrays.toString(ans));
    }
}
