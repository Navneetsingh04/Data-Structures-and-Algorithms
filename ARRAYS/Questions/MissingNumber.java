/*
L.C 268. Missing Number

Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
Example 2:

Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
Example 3:

Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 
Constraints:
n == nums.length
1 <= n <= 104
0 <= nums[i] <= n
All the numbers of nums are unique.
 */
// 1st Approach using math operations

// Time compexity : O(n);
// space complexity : O(1)
// import java.util.Arrays;
public class MissingNumber {
    public static int missingNumber(int arr[]){
        int n = arr.length;
        int sum = 0;
        for(int i = 0;i<n;i++){
            sum += arr[i];
        }
        int totalSum = (n*(n+1))/2;
        int ans = totalSum-sum;
        return ans;
    }

    // 2nd Approach using sorting
    // Time compexity : O(nlogn);
    // space complexity : O(1)
    // public static int missingNumber(int arr[]){
    //     Arrays.sort(arr);
    //     for(int i = 0;i<arr.length;i++){
    //         if(arr[i] != i){
    //             return i;
    //         }
    //     }
    //     return 0;
    // }

    public static void main(String[] args) {
        int arr[] = new int[]{9,6,4,2,8,3,7,0,1};
        int result = missingNumber(arr);
        System.out.println("Missing number from the array is "+result);

    }
}
