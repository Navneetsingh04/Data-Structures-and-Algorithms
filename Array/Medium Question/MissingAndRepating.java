/*
L.C: Missing And Repeating

Given an unsorted array arr of of positive integers. One number 'A' from set {1, 2,....,n} is missing and one number 'B' occurs twice in array. Find numbers A and B.

Examples

Input: arr[] = [2, 2]
Output: 2 1
Explanation: Repeating number is 2 and smallest positive missing number is 1.
Input: arr[] = [1, 3, 3] 
Output: 3 2
Explanation: Repeating number is 3 and smallest positive missing number is 2.


Constraints:
2 ≤ n ≤ 105
1 ≤ arr[i] ≤ n
*/

import java.util.Arrays;

public class MissingAndRepating {
    // time complexity : O(2n)
    // Space Complexity : O(n)

    // public static int[] findTwoElement(int arr[]) {
    //     int n = arr.length;
    //     int hash[] = new int[n+1];
    //     Arrays.fill(hash,0);
    //     for(int i = 0;i<n;i++){
    //         hash[arr[i]]++;
    //     }
    //     int repeating = -1;
    //     int missing = -1;
    //     for(int i = 1;i<=n;i++){
    //         if(hash[i] == 2){
    //             repeating = i;
    //         }
    //         else if(hash[i] == 0){
    //             missing = i;
    //         }
    //         if(repeating != -1 && missing != -1){
    //             break;
    //         }
    //     }
    //     return new int[]{repeating,missing};
    // }

    //  time complexity : O(n)
    // Space Complexity : O(1)
    public static int[] findTwoElement(int arr[]) {
        int n = arr.length;
        int xor = 0;
        for(int i  = 0;i<n;i++){
            xor = xor^arr[i];
            xor = xor^(i+1);
        }
        int bitNo = (xor & ~(xor -1));
       
        int zero = 0;
        int one = 0;
        for(int i = 0;i<n;i++){
            // part of zero
            if((arr[i] & bitNo) != 0){
                one ^= arr[i];
            }
            else{
                zero ^= arr[i];
            }
        }
        for(int i = 1;i<=n;i++){
             if((i & bitNo) != 0){
                one ^= i;
            }
            else{
                zero ^= i;
            }
        }
        int count = 0;
        for(int i = 0;i<n;i++){
            if(arr[i] == zero) count++;
        }
        if(count ==2){
            return new int[]{zero,one};
        }
        return new int[]{one,zero};
    }
    public static void main(String[] args) {
        int arr[] = {1, 3, 3};
        int ans[] = findTwoElement(arr);
        System.out.println(Arrays.toString(ans));
    }
}
