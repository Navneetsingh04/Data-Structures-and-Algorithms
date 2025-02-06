/*
L.C: 1347. Minimum Number of Steps to Make Two Strings Anagram

You are given two strings of the same length s and t. In one step you can choose any character of t and replace it with another character.
Return the minimum number of steps to make t an anagram of s.

An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.

Example 1:
Input: s = "bab", t = "aba"
Output: 1
Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.

Example 2:
Input: s = "leetcode", t = "practice"
Output: 5
Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.

Example 3:
Input: s = "anagram", t = "mangaar"
Output: 0
Explanation: "anagram" and "mangaar" are anagrams. 
 
Constraints:
1 <= s.length <= 5 * 104
s.length == t.length
s and t consist of lowercase English letters only.
*/
public class MinStepsToMakeTwoStringAnagram {
    public static int minSteps(String s,String t){
        int countS[] = new int[26];
        int countT[] = new int[26];

        for(char ch : s.toCharArray()){
            countS[ch-'a']++;
        }
        for(char ch :t.toCharArray()){
            countT[ch-'a']++;
        }
        int steps = 0;
        for(int i = 0;i<26;i++){
            steps += Math.abs(countS[i]-countT[i]);
        }
        return steps/2;
    }
    public static void main(String[] args) {
        String s = "leetcode";
        String t = "practice";
        System.out.println(minSteps(s, t));
    }
}
