/*
L.C: 172. Factorial Trailing Zeroes

Given an integer n, return the number of trailing zeroes in n!.

Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.

Example 1:

Input: n = 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: n = 5
Output: 1
Explanation: 5! = 120, one trailing zero.
Example 3:

Input: n = 0
Output: 0
 

Constraints:

0 <= n <= 104
*/
public class FactorialTrailingZeroes {
    public static int trailingZeroes(int n) {
        int zeros = 0;
        while(n >= 5){
            n = n/5;
            zeros += n;
        }
        return zeros;
    }
    public static void main(String[] args) {
        int n = 142;
        System.out.println("The number of trailing zeroes: "+trailingZeroes(n));
    }
}
