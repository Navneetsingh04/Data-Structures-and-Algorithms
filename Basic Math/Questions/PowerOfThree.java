/*
L.C: 326. Power of Three

Given an integer n, return true if it is a power of three. Otherwise, return false.

An integer n is a power of three, if there exists an integer x such that n == 3x.

Example 1:
Input: n = 27
Output: true
Explanation: 27 = 33

Example 2:
Input: n = 0
Output: false
Explanation: There is no x where 3x = 0.

Example 3:
Input: n = -1
Output: false
Explanation: There is no x where 3x = (-1).
 
Constraints:
-231 <= n <= 231 - 1 
*/
public class PowerOfThree{
    // approach 1
    public static boolean isPowerOfThree(int n) {
        if(n <= 0) return false;
        while(n%3 == 0){
            n = n/3;
        }
        return n == 1;
    }
    // approach 2
    public static boolean isPowerOfThreeI(int n) {
        if(n <= 0) return false;
        if(n == 1) return true;
        return n%3 ==0 && isPowerOfThree(n/3);
    }
    // approach 3
    public static boolean isPowerOfThreeII(int n) {
        int pow = (int)Math.pow(3,19);
        return n > 0 && pow%n == 0;
    }
    public static void main(String[] args) {
        int n = 81;
        System.out.println(isPowerOfThree(n));
    }
}