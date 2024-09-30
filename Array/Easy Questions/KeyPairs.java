/*
Given an array Arr of N positive integers and another number X. Determine whether or not there exist two elements in Arr whose sum is exactly X.

Example 1:

Input:
N = 6, X = 16
Arr[] = {1, 4, 45, 6, 10, 8}
Output: Yes
Explanation: Arr[3] + Arr[4] = 6 + 10 = 16
Example 2:

Input:
N = 5, X = 10
Arr[] = {1, 2, 4, 3, 6}
Output: Yes
Explanation: Arr[2] + Arr[4] = 4 + 6 = 10
 */

//  1st Approach : Brut force
//  Time compexity : O(n^2)
//  space compexity :O(1)

import java.util.Scanner;
import java.util.Arrays;
// public class KeyPairs {
//     public static boolean keyPairs(int arr[],int target){
//         int n = arr.length;
//         for(int i = 0;i<n;i++){
//             for(int j = i+1;j<n;j++){
//                 int sum = arr[i]+arr[j];
//                 if(sum == target){
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }

//  1st Approach : Two pointer Approach
//  Time compexity : O(n)
//  space compexity: O(n)

public class KeyPairs {
    public static boolean keyPairs(int arr[],int target){
        Arrays.sort(arr);
        int n = arr.length;
        int left = 0;
        int right = n-1;
        while(left<right){
            int sum = arr[left]+arr[right];
            if(sum == target){
                return true;
            }
            else if(sum>target){
                right--;
            }
            else{
                left++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int arr[] = new int[] {1, 4, 45, 6, 10, 8};
        System.out.println("Enter value of x: ");
        int x = s.nextInt();
        boolean result = keyPairs(arr,x);
        System.out.println(result);
        s.close();
    }
}
