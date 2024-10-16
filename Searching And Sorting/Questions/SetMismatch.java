/*
L.C: 645. Set Mismatch
You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.

Example 1:

Input: nums = [1,2,2,4]
Output: [2,3]
Example 2:

Input: nums = [1,1]
Output: [1,2]
 

Constraints:

2 <= nums.length <= 104
1 <= nums[i] <= 104
*/
// Time complexity : O(n)
public class SetMismatch {
    static int[]  setMismatch(int arr[]){
        int n = arr.length;
        int i = 0;
        while(i<n){
            int correctIndex = arr[i]-1;
            if(arr[i] != arr[correctIndex]){
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
               return new int[]{arr[i],i+1};
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,2,6};
        int result[] = setMismatch(arr);
        System.out.print("Set Missmatch element: ");
        System.out.print("{");
        for(int i: result){
        System.out.print(i+",");
        }
        System.out.print("}");
    }
}
