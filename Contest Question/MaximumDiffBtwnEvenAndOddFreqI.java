/*
Q1. Maximum Difference Between Even and Odd Frequency I

You are given a string s consisting of lowercase English letters. Your task is to find the maximum difference between the frequency of two characters in the string such that:

One of the characters has an even frequency in the string.
The other character has an odd frequency in the string.
Return the maximum difference, calculated as the frequency of the character with an odd frequency minus the frequency of the character with an even frequency.

Example 1:
Input: s = "aaaaabbc"
Output: 3
Explanation:
The character 'a' has an odd frequency of 5, and 'b' has an even frequency of 2.
The maximum difference is 5 - 2 = 3.

Example 2:
Input: s = "abcabcab"
Output: 1
Explanation:
The character 'a' has an odd frequency of 3, and 'c' has an even frequency of 2.
The maximum difference is 3 - 2 = 1.
 
Constraints:
3 <= s.length <= 100
s consists only of lowercase English letters.
s contains at least one character with an odd frequency and one with an even frequency. 
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumDiffBtwnEvenAndOddFreqI {
    public static int maxDifference(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        List<Integer> oddfreq = new ArrayList<>();
        List<Integer> evenfreq = new ArrayList<>();

        for(int freq : map.values()) {
            if(freq%2 == 0){
                evenfreq.add(freq);
            }
            else{
                oddfreq.add(freq);
            }
        }
        if(oddfreq.isEmpty() || evenfreq.isEmpty()){
            return 0;
        }
        int maxOdd = Collections.max(oddfreq);
        int minEven = Collections.min(evenfreq);

        return maxOdd-minEven;
    }
    public static void main(String[] args) {
        String s = "aaaaabbc";
        System.out.println(maxDifference(s));
    }
}
