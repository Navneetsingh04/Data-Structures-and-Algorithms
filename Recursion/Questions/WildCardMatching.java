/*
L.C: 44. Wildcard Matching

Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Example 1:
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:
Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.

Constraints:

0 <= s.length, p.length <= 2000
s contains only lowercase English letters.
p contains only lowercase English letters, '?' or '*'.
 */
// Time complexity : O(2^n)
// space complexity: O(n)
public class WildCardMatching {
    public static boolean isMatchHelper(String s,int si,String p,int pi){
        if(si == s.length() && pi == p.length()){
            return true;
        }
        if(si == s.length()){
            while(pi< p.length()){
                if(p.charAt(pi) != '*'){
                    return false;
                }
                pi++;
            }
            return true;
        }
        if(pi == p.length()){
            return false;
        }

        // single charcter Matching
        if(s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?'){
            return isMatchHelper(s, si+1, p, pi+1);
        }
        if(p.charAt(pi) == '*'){
            // traet '*' as empty or null
            boolean caseA = isMatchHelper(s, si, p, pi+1);
            // treat '*' consume single character
            boolean caseB = isMatchHelper(s, si+1, p, pi);
            return caseA || caseB;
        }
        return false;
    }
    public static boolean wildcardMatching(String s,String p){
        int si = 0;
        int pi = 0;
        return isMatchHelper(s,si,p,pi);
    }
    public static void main(String args[]){
        String s = "abcdefg";
        String p = "ab*fg";
        System.out.println(wildcardMatching(s, p));
    }
}