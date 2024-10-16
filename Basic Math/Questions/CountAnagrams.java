/*
L.C: 2514. Count Anagrams

You are given a string s containing one or more words. Every consecutive pair of words is separated by a single space ' '.

A string t is an anagram of string s if the ith word of t is a permutation of the ith word of s.

For example, "acb dfe" is an anagram of "abc def", but "def cab" and "adc bef" are not.
Return the number of distinct anagrams of s. Since the answer may be very large, return it modulo 109 + 7.


Example 1:

Input: s = "too hot"
Output: 18
Explanation: Some of the anagrams of the given string are "too hot", "oot hot", "oto toh", "too toh", and "too oht".
Example 2:

Input: s = "aa"
Output: 1
Explanation: There is only one anagram possible for the given string.
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters and spaces ' '.
There is single space between consecutive words. 
*/
// Time Complexity:  O(W*K)
// Space Complexity:  O(N)
import java.math.BigInteger;

public class CountAnagrams {
    // taking mod of larger number to prevent overflow
    static int mod = (int)1e9+7;
    public static int countAnagrams(String s) {
        int n = s.length();
        // array to store precomputed factorials
        long[] factorials = new long[n+1];
        factorials[0] = 1;  // 0! = 1

        // Calculate factorial for each number up to n, with mod
        for(int i = 1;i<=n;i++){
            factorials[i] = (factorials[i-1]*i)%mod;
        }
        long product = 1;
        for(String i : s.split(" ")){
            int[] charCount = new int[26];
            // Count the frequency of each character in the current word
            for(int j = 0;j<i.length();j++){
                charCount[i.charAt(j)-'a']++;
            }
            // Multiply the product by the factorial of the length of the word
            product = (product*factorials[i.length()])%mod;

            // Iterating over the character frequencies,
            // taking the modInverse of their factorial, and updating the product
            for(int count : charCount){
                if(count >0){
                    BigInteger factorial = BigInteger.valueOf(factorials[count]);
                    BigInteger modInverse = factorial.modInverse(BigInteger.valueOf(mod));
                    product = (product*modInverse.intValue())%mod;
                }
            }
        }
        return (int)product;
    }
    public static void main(String[] args) {
        String s = "too hot";
        System.out.println(countAnagrams(s));
    }
}
