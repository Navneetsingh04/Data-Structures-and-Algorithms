/*
L.C: 1780. Check if Number is a Sum of Powers of Three

Given an integer n, return true if it is possible to represent n as the sum of distinct powers of three. Otherwise, return false.
An integer y is a power of three if there exists an integer x such that y == 3x.

Example 1:
Input: n = 12
Output: true
Explanation: 12 = 31 + 32

Example 2:
Input: n = 91
Output: true
Explanation: 91 = 30 + 32 + 3

Example 3:
Input: n = 21
Output: false

Constraints:
1 <= n <= 107 
*/

public class CheckNumSumPowThree {
    // Approach 1 : simple Math
    // Time Complexity : O(log3(n))
    public static boolean checkPowersOfThree(int n){
        int p = 0;
        while(n >= Math.pow(3, p)){
            p++;
        }
        while(n>0){
            if(n >= Math.pow(3, p)){
                n = n - (int)Math.pow(3, p);
            }
            if(n >= Math.pow(3, p)){
                return false;
            }
            p--;
        }
        return true;
    }

    // Approach 2: binary representation
    // Time Complexity : O(log3(n))
    public static boolean checkPowersOfThree2(int n){
        while(n > 0){
            if(n%3 == 2){
                return false;
            }
            n = n/3;
        }
        return true;
    }
    public static void main(String[] args) {
        int n = 91;
        System.out.println(checkPowersOfThree(n));
        System.out.println(checkPowersOfThree2(n));
    }
}
