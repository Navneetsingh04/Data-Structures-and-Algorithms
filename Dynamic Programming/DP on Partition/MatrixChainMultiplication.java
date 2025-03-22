/*
Matrix Chain Multiplication

Given an array arr[] which represents the dimensions of a sequence of matrices where the ith matrix has the dimensions (arr[i-1] x arr[i]) for i>=1, find the most efficient way to multiply these matrices together. The efficient way is the one that involves the least number of multiplications.

Examples:

Input: arr[] = [2, 1, 3, 4]
Output: 20
Explanation: There are 3 matrices of dimensions 2 × 1, 1 × 3, and 3 × 4, Let this 3 input matrices be M1, M2, and M3. There are two ways to multiply: ((M1 x M2) x M3) and (M1 x (M2 x M3)), note that the result of (M1 x M2) is a 2 x 3 matrix and result of (M2 x M3) is a 1 x 4 matrix. 
((M1 x M2) x M3)  requires (2 x 1 x 3) + (2 x 3 x 4) = 30 
(M1 x (M2 x M3))  requires (1 x 3 x 4) + (2 x 1 x 4) = 20. 
The minimum of these two is 20.
Input: arr[] = [1, 2, 3, 4, 3]
Output: 30
Explanation: There are 4 matrices of dimensions 1 × 2, 2 × 3, 3 × 4, 4 × 3. Let this 4 input matrices be M1, M2, M3 and M4. The minimum number of multiplications are obtained by ((M1 x M2) x M3) x M4). The minimum number is (1 x 2 x 3) + (1 x 3 x 4) + (1 x 4 x 3) = 30.

Input: arr[] = [3, 4]
Output: 0
Explanation: As there is only one matrix so, there is no cost of multiplication.
Constraints: 
2 ≤ arr.size() ≤ 100
1 ≤ arr[i] ≤ 200 
*/

import java.util.Arrays;
public class MatrixChainMultiplication {

    // Approach 1: Recursion
    // Time Complexity: O(2^n)
    // Space Complexity: O(n)

    public static int fun(int i,int j,int arr[]){
        if(i == j) return 0;
        int mini = Integer.MAX_VALUE;
        for(int k = i;k<j;k++){
            int steps = arr[i-1]*arr[k]*arr[j]+ fun(i,k,arr)+fun(k+1,j,arr);
            if(steps<mini){
                mini = steps;
            }
        }
        return mini;
    }
    public static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        return fun(1,n-1,arr);
    }

    // Approach 2: Top Down DP(Recursion + Memoization)
    // Time Complexity: O(n^3) 
    // Space Complexity: O(n^2)+O(n) ~ O(n^2)

    public static int funI(int i,int j,int arr[],int dp[][]){
        if(i == j) return 0;
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int mini = Integer.MAX_VALUE;
        for(int k = i;k<j;k++){
            int steps = arr[i-1]*arr[k]*arr[j]+ funI(i,k,arr,dp)+funI(k+1,j,arr,dp);
            if(steps<mini){
                mini = steps;
            }
        }
        return dp[i][j] = mini;
    }
    public static int matrixMultiplicationI(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        return funI(1,n-1,arr,dp);
    }

    // Approach 3: Bottom Up DP(Tabulation)
    // Time Complexity: O(n^3)
    // Space Complexity: O(n^2)

    public static int matrixMultiplicationII(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];
        for(int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        for(int i = n-1;i>0;i--){
            for(int j = i+1;j<n;j++) {
                int mini = Integer.MAX_VALUE;
                for(int k = i;k<j;k++){
                    int steps = arr[i-1]*arr[k]*arr[j]+dp[i][k]+dp[k+1][j];
                    mini = Math.min(mini, steps);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][n-1];
    }
    public static void main(String[] args) {
        int arr[] = {2, 1, 3, 4};
        System.out.println(matrixMultiplication(arr));
        System.out.println(matrixMultiplicationI(arr));
        System.out.println(matrixMultiplicationII(arr));
        
    }
}
