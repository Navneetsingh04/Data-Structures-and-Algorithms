/*
L.C: 29. Divide Two Integers

Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

Return the quotient after dividing dividend by divisor.

Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.


Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = 3.33333.. which is truncated to 3.
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = -2.33333.. which is truncated to -2.
 
Constraints:

-231 <= dividend, divisor <= 231 - 1
divisor != 0 
*/
public class DivideTwoInteger {
    // Time complexity: O(log a * log b) 
    // Space Complexity: O(1)
    public static int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;
        int sign = 1;
        if((dividend >= 0 && divisor < 0) || (dividend <= 0 && divisor > 0)){
            sign = -1;
        } 
        long longDividend = Math.abs((long)dividend);
        long longDivisor = Math.abs((long)divisor);
        long quotient = 0;
        while(longDividend >= longDivisor){
            int count = 0;
            while(longDividend  >= (longDivisor << (count+1))){
                count++;
            }
            quotient += 1L << count;
            longDividend -= (longDivisor << count);
        }
        long ans = sign*quotient;
        // overFlow condition
        if(ans >= Integer.MIN_VALUE && ans <= Integer.MAX_VALUE) {
            return (int)ans;
        }
        return Integer.MAX_VALUE;
    }
    public static void main(String[] args) {
        int dividend = 10,divisor = 3;
        System.out.println(divide(dividend, divisor));
    }
}
