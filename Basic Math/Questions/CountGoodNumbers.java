/*
L.C: 1922. Count Good Numbers

A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).

For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime. However, "3245" is not good because 3 is at an even index but is not even.
Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 109 + 7.

A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.


Example 1:
Input: n = 1
Output: 5
Explanation: The good numbers of length 1 are "0", "2", "4", "6", "8".

Example 2:
Input: n = 4
Output: 400

Example 3:
Input: n = 50
Output: 564908303
 
Constraints:
1 <= n <= 10^15
*/
// Time Complexity: O(log(n))
public class CountGoodNumbers {
    public static long modPow(long x,long n){
        long ans = 1;
        long mod = (long)1e9+7;
        while(n>0){
            if((n&1) == 1){
                ans = (ans*x)%mod;
            }
            n = n/2;
            x = (x*x)%mod;
        }
        return ans;
    }
    public static int countGoodNumber(long n){
        long mod = (long)1e9+7;
        long even,odd;
        // dteremine the count of even and odd position
        if((n&1) == 1){
            even = (n/2)+1;
            odd = n/2;
        }
        else{
            even = odd = n/2;
        }
        long evenPower = modPow(5,even);
        long oddPower = modPow(4,odd);
        return (int)((evenPower*oddPower)%mod);
    }
    public static void main(String[] args) {
        long n = 50;
        System.out.println(countGoodNumber(n));
    }
}
