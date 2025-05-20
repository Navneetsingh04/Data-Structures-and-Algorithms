/*
L.C: 1524. Number of Sub-arrays With Odd Sum

Given an array of integers arr, return the number of subarrays with an odd sum.
Since the answer can be very large, return it modulo 109 + 7.

Example 1:
Input: arr = [1,3,5]
Output: 4
Explanation: All subarrays are [[1],[1,3],[1,3,5],[3],[3,5],[5]]
All sub-arrays sum are [1,4,9,3,8,5].
Odd sums are [1,9,3,5] so the answer is 4.

Example 2:
Input: arr = [2,4,6]
Output: 0
Explanation: All subarrays are [[2],[2,4],[2,4,6],[4],[4,6],[6]]
All sub-arrays sum are [2,6,12,4,10,6].
All sub-arrays have even sum and the answer is 0.

Example 3:
Input: arr = [1,2,3,4,5,6,7]
Output: 16

Constraints:
1 <= arr.length <= 105
1 <= arr[i] <= 100 
*/
public class NumberOfSubarrWithOddSum {
    // Approach 1: Brute Force
    // T.C: O(n^2)
    // S.C: O(1)

    // public static int numOfSubarrays(int[] arr){
    //     int n = arr.length;
    //     int MOD = (int)1e9+7;
    //     int count = 0;
    //     for(int i = 0;i<n;i++){
    //         int sum = 0;
    //         for(int j = i;j<n;j++){
    //             sum += j;
    //             if(sum%2 != 0){
    //                 count = (count+1)%MOD;
    //             }
    //         }
    //     }
    //     return count;
    // }

    // Approach 2: Prefix sum
    // T.C: O(n^2)
    // S.C: O(1)

    public static int numOfSubarrays(int[] arr){
        int MOD = (int)1e9+7;
        int count = 0;
        int oddCount = 0,evenCount = 1,sum = 0;
        for(int i : arr){
            sum += i;
            if(sum%2 == 0){
                count = (count+oddCount)%MOD;
                evenCount++;
            }
            else{
                count = (count+evenCount)%MOD;
                oddCount++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[] = {1,3,5};
        System.out.println(numOfSubarrays(arr));
    }
}
