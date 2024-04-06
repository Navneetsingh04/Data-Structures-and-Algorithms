/*
L.C: 41. First Missing Positive

Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.
 

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
*/
// Time complexity : O(n)

public class FirstPositveMissingElemnt {
    static int firstPositveMissingElemnt(int arr[]){
        int n = arr.length;
        int i = 0;
        while(i<n){
            int correctIndex = arr[i]-1;
            if(arr[i]> 0 && arr[i] <= n && arr[i] != arr[correctIndex]){
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            }
            else{
                i++;
            }
        }
        for(i = 0;i<n;i++){
            if(arr[i] != i+1){
                return i+1;
            }
        }
        return n+1;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5};
        int result = firstPositveMissingElemnt(arr);
        System.out.println("First +Ve missning number is "+result);
    }
}
