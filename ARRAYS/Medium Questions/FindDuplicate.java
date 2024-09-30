/*
L.C : 287. Find the Duplicate Number

Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and uses only constant extra space.

Example 1:
Input: nums = [1,3,4,2,2]
Output: 2

Example 2:
Input: nums = [3,1,3,4,2]
Output: 3

Example 3:
Input: nums = [3,3,3,3,3]
Output: 3
 
Constraints:
1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.
*/

// 1st Approach : using sorting
// time complexity : O(nlogn)
// space complexity : O(n)
// import java.util.Arrays;
// public class FindDuplicate {
//     public static int findDuplicate(int arr[]){
//         Arrays.sort(arr);
//         int n = arr.length;
//         for(int i = 1;i<n;i++){
//             if(arr[i] ==arr[i-1]){
//                 return arr[i];
//             }
//         }
//         return -1;
//     }

// 2nd Approach 
// Time complexity : O(n)
// space complexity : O(1)

// public class FindDuplicate {
//     public static int findDuplicate(int arr[]){
//         int n = arr.length;
//         int ans = -1;
//         for(int i = 0;i<n;i++){
//             int index = Math.abs(arr[i]);
//             if(arr[index]<0){
//                 ans = index;
//                 break;
//             }
//             arr[index] *= -1;
//         }
//         return ans;
//     }

// 3rd Approach : positioning Approach
// Time complexity : O(n)
// space complexity : O(1)

public class FindDuplicate {
    public static int findDuplicate(int arr[]){
        while(arr[0] != arr[arr[0]]){
            int temp = arr[arr[0]];
            arr[arr[0]] =  arr[0];
            arr[0] = temp;
        }
        return arr[0];
    }
    public static void main(String[] args) {
        // int arr[] = new int[]{1,3,2,2};
        int arr[] = new int[]{3,1,3,4,2};
        // int arr[] = new int[]{3,3,3,3,3};
        // int arr[] = new int[]{1,3,2,4,4,5};
        int result = findDuplicate(arr);
        System.out.println("Duplicate Number in the array is "+result);
    }
}
