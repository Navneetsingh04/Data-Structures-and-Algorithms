/*
L.C: 873. Length of Longest Fibonacci Subsequence

A sequence x1, x2, ..., xn is Fibonacci-like if:
n >= 3
xi + xi+1 == xi+2 for all i + 2 <= n
Given a strictly increasing array arr of positive integers forming a sequence, return the length of the longest Fibonacci-like subsequence of arr. If one does not exist, return 0.

A subsequence is derived from another sequence arr by deleting any number of elements (including none) from arr, without changing the order of the remaining elements. For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].

Example 1:
Input: arr = [1,2,3,4,5,6,7,8]
Output: 5
Explanation: The longest subsequence that is fibonacci-like: [1,2,3,5,8].

Example 2:
Input: arr = [1,3,7,11,12,14,18]
Output: 3
Explanation: The longest subsequence that is fibonacci-like: [1,11,12], [3,11,14] or [7,11,18].
 
Constraints:
3 <= arr.length <= 1000
1 <= arr[i] < arr[i + 1] <= 109
*/
import java.util.*;
public class LengthOfLongestFibonacciSubsequence {
    // Approach 1
    // T.C: O(n^3)
    
    // public static int solve(int j,int k,int arr[],Map<Integer,Integer> map){
    //     int target = arr[k] - arr[j];
    //     if(target >= arr[j] || !map.containsKey(target)){
    //         return 2;
    //     }
    //     int i = map.get(target);
    //     return 1+solve(i,j,arr,map);
    // }
    // public static int lenLongestFibSubseq(int[] arr) {
    //     int n = arr.length;
    //     Map<Integer,Integer> map = new HashMap<>();
    //     for(int i = 0;i<n;i++){
    //         map.put(arr[i],i);
    //     }
    //     int maxLen = 0;
    //     for(int j = 1;j<n;j++){
    //         for(int k = j;k<n;k++){
    //             int len = solve(j,k,arr,map);
    //             if(len >= 3){
    //                 maxLen = Math.max(maxLen,len);
    //             }
    //         }
    //     }
    //     return maxLen;
    // }
    // 2nd Approach 
    // T.C: O(n^2)
    public static int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        int dp[][] = new int[n][n];
        for(int row[] : dp){
            Arrays.fill(row,2);
        }
        for(int i = 0;i<n;i++){
            map.put(arr[i],i);
        }
        int maxLen = 0;

        for(int j = 1;j<n;j++){
            for(int k = j+1;k<n;k++){
                int target = arr[k] - arr[j];
                if(map.containsKey(target) && map.get(target) < j){
                    int i = map.get(target);
                    dp[j][k] = dp[i][j]+1;
                }
                maxLen = Math.max(maxLen,dp[j][k]);
            }
        }
        return maxLen >= 3 ? maxLen : 0;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println(lenLongestFibSubseq(arr));
    }
}
