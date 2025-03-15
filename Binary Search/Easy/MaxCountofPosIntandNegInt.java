/*
L.C: 2529. Maximum Count of Positive Integer and Negative Integer

Given an array nums sorted in non-decreasing order, return the maximum between the number of positive integers and the number of negative integers.

In other words, if the number of positive integers in nums is pos and the number of negative integers is neg, then return the maximum of pos and neg.
Note that 0 is neither positive nor negative.


Example 1:
Input: nums = [-2,-1,-1,1,2,3]
Output: 3
Explanation: There are 3 positive integers and 3 negative integers. The maximum count among them is 3.

Example 2:
Input: nums = [-3,-2,-1,0,0,1,2]
Output: 3
Explanation: There are 2 positive integers and 3 negative integers. The maximum count among them is 3.

Example 3:
Input: nums = [5,20,66,1314]
Output: 4
Explanation: There are 4 positive integers and 0 negative integers. The maximum count among them is 4.
 
Constraints:
1 <= nums.length <= 2000
-2000 <= nums[i] <= 2000
nums is sorted in a non-decreasing order. 
*/
public class MaxCountofPosIntandNegInt {
    
    // Approach 1: Brute Force
    // T.C: O(n)
    // S.C: O(1)

    public static int maximumCount(int[] nums) {
        int n = nums.length;
        int countNeg = 0,countPos = 0;
        for(int i = 0;i<n;i++){
            if(nums[i] < 0){
                countNeg++;
            }
            else if(nums[i] == 0) continue;
            else{
                countPos++;
            }
        }
        return Math.max(countNeg,countPos);
    }

    // Approach 1: Binary Search
    // T.C: O(nlogn)
    // S.C: O(1)

    public static int maximumCountBS(int[] nums) {
        int n = nums.length;
        int firstNonNeg = binarySearch(nums,0,n);
        int firstPos = binarySearch(nums,1,n);

        int countNeg = firstNonNeg;
        int countPos = n-firstPos;

        return Math.max(countNeg,countPos);
    }
    public static int binarySearch(int nums[],int target,int n){
        int i = 0,j = n;
        while(i<j){
            int mid = i+(j-i)/2;
            if(nums[mid] >= target){
                j = mid;
            }
            else{
                i = mid+1;
            }
        }
        return i;
    }
    public static void main(String[] args) {
        
    }
}
