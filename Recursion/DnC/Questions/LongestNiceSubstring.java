/*
L.C: 1763. Longest Nice Substring

A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase. For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear. However, "abA" is not because 'b' appears, but 'B' does not.

Given a string s, return the longest substring of s that is nice. If there are multiple, return the substring of the earliest occurrence. If there are none, return an empty string.

Example 1:

Input: s = "YazaAay"
Output: "aAa"
Explanation: "aAa" is a nice string because 'A/a' is the only letter of the alphabet in s, and both 'A' and 'a' appear.
"aAa" is the longest nice substring.
Example 2:

Input: s = "Bb"
Output: "Bb"
Explanation: "Bb" is a nice string because both 'B' and 'b' appear. The whole string is a substring.
Example 3:

Input: s = "c"
Output: ""
Explanation: There are no nice substrings.
 

Constraints:

1 <= s.length <= 100
s consists of uppercase and lowercase English letters. 
*/

import java.util.HashSet;
import java.util.Set;

public class LongestNiceSubstring {
    public static String longestNiceSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        for(char c: s.toCharArray()){
            set.add(c);
        }
        for(int i = 0;i<n;i++){
            char ch = s.charAt(i);
            if(set.contains(Character.toUpperCase(ch)) && set.contains(Character.toLowerCase(ch))){
                continue;
            }
            String left = longestNiceSubstring(s.substring(0,i));
            String right = longestNiceSubstring(s.substring(i+1));
            return left.length() >= right.length() ? left : right;
        }
        return s;
    }
    public static void main(String[] args) {
        String s = "YazaAay";
        System.out.println(longestNiceSubstring(s)); 
    }
}
