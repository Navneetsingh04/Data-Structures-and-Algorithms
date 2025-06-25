/*
Maximum Sum of Subarray of Constant Size K

Given an array of integers arr[] and an integer k,
where k is a constant,
your task is to find the maximum sum of any contiguous subarray of size k.

Input:
An integer array arr[] of length n (1 ≤ n ≤ 10^5)
An integer k (1 ≤ k ≤ n), representing the fixed window size 
*/

public class MaxSubarraySum {
    // Approach: Brute force
    // Time complexity: O(n*k)
    // Space complexity: O(1)
    public static int maxSubarraySum(int arr[],int k){
        int n = arr.length;
        if(k > n) return -1; 
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0;i<=n-k;i++){
            int sum = 0;
            for(int j = i;j<i+k;j++){
                sum += arr[j];
            }
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }

    // Approach: Sliding window
    // Time complexity: O(n)
    // Space complexity: O(1)

    public static int maxSubarraySumI(int arr[],int k){
        int n = arr.length;
        if(k > n) return -1;

        int l = 0,r = k-1;
        int windowSum = 0;

        for(int i = l;i <= r;i++){
            windowSum += arr[i];
        }
        int maxSum = windowSum;

        while(r < n-1){
            windowSum -= arr[l];
            l++;
            r++;
            windowSum += arr[r];

            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int arr[] = {-1,2,3,3,4,5,-1};
        int k = 4;
        System.out.println(maxSubarraySum(arr, k));
        System.out.println(maxSubarraySumI(arr, k));
    }
}
