/*
L.C: 509. Fibonacci Number

The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).

Example 1:
Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.

Example 2:
Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.

Example 3:
Input: n = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 
Constraints:
0 <= n <= 30
*/

import java.util.Scanner;
public class FibonacciNumber {
    public static int solve(int n,int dp[]){
        if(n == 0 || n == 1) return n;
        //Step 3: if ans already exits return ans
        if(dp[n] != -1){
            return dp[n];
        }
        // Stpe 2: store and return using dp array
        dp[n] = solve(n-1, dp)+solve(n-2, dp);
        return dp[n];
    }
    public static int fib(int n){
        // Step 1: creating dp array and Initialized with -1
        int dp[] = new int[n+1];
        for(int i = 0;i<=n;i++){
            dp[i] = -1;
        }
        int ans = solve(n,dp);
        return ans;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = s.nextInt();
        System.out.println(fib(n));
        s.close();
    }
}
