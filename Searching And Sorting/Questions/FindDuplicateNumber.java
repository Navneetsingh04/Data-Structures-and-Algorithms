/*
287. Find the Duplicate Number
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

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

// Time complexity : O(n)
public class FindDuplicateNumber {
    static int findDuplicateNumber(int arr[]){
        int n = arr.length;
        int i = 0;
        while(i<n){
            int corretIndex = arr[i]-1;
            if(arr[i] != arr[corretIndex]){
                int temp = arr[i];
                arr[i] = arr[corretIndex];
                arr[corretIndex] = temp;
            }
            else{
                i++;
            }
        }
        for(i = 0;i<n;i++){
            if(arr[i] != i+1){
                return arr[i];
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{2,3,4,1,7,5,6,7};
        int result = findDuplicateNumber(arr);
        System.out.println("Duplicate number is "+result);
    }
}
