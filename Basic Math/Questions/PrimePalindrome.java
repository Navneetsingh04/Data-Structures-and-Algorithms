/*
L.C: 866. Prime Palindrome

Given an integer n, return the smallest prime palindrome greater than or equal to n.

An integer is prime if it has exactly two divisors: 1 and itself. Note that 1 is not a prime number.

For example, 2, 3, 5, 7, 11, and 13 are all primes.
An integer is a palindrome if it reads the same from left to right as it does from right to left.

For example, 101 and 12321 are palindromes.
The test cases are generated so that the answer always exists and is in the range [2, 2 * 108].


Example 1:
Input: n = 6
Output: 7

Example 2:
Input: n = 8
Output: 11

Example 3:
Input: n = 13
Output: 101

Constraints:
1 <= n <= 108 
*/
// Time Complexity: O(n.sqrt(n))
// Space Complexity:O(logn)
public class PrimePalindrome {
    public static boolean isPrime(int n){
        if(n<=1) return false;
        if(n<=3) return true;
        if(n%2 == 0 || n%3 == 0) return false;
        for(int i = 5;i*i<=n;i += 6){
            if(n%i == 0 || n%(i+2) == 0){
                return false;
            }
        }
        return true;
    }
    public static boolean isPalindrome(int n){
        String s = Integer.toString(n);
        return s.equals(new StringBuilder(s).reverse().toString());
    }
    public static int primePalindrome(int n) {
        while(true){
            if(isPrime(n) && isPalindrome(n)){
                return n;
            }
           n++;
           if(10_000_000 < n && n < 100_000_000) {
                n = 100_000_000;
            }
        }
    }
    public static void main(String[] args) {
        int n = 13;
        System.out.println(primePalindrome(n));
    }
}
