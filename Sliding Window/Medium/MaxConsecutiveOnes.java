/*
L.C: 1004. Max Consecutive Ones III

Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Example 1:
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

Example 2:
Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 
Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length
 */
public class MaxConsecutiveOnes {
    public static int longestOnes(int arr[],int k){
        int n = arr.length;
        int left = 0,right = 0,zeroCount = 0,maxLen = 0;
        while(right<n){
            if(arr[right] == 0){
                zeroCount++;
            }
            if(zeroCount>k){
                if(arr[left] == 0){
                    zeroCount--;
                }
                left++;
            }
            if(zeroCount<=k){
                int len = right-left+1;
                maxLen = Math.max(maxLen,len);
            }
            right++;
        }
        return maxLen;
    }
    public static void main(String args[]){
        int arr[]  = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println("Maximum length of subarray with consecutive 1's: "+longestOnes(arr, k));
    }
}