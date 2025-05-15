/*
Longest Substring with K Uniques

Given a string s, you need to print the size of the longest possible substring with exactly k unique characters. If no possible substring exists, print -1.
Examples:

Input: s = "aabacbebebe", k = 3
Output: 7
Explanation: "cbebebe" is the longest substring with 3 distinct characters.

Input: s = "aaaa", k = 2
Output: -1
Explanation: There's no substring with 2 distinct characters.

Input: s = "aabaaab", k = 2
Output: 7
Explanation: "aabaaab" is the longest substring with 2 distinct characters.

Constraints:
1 ≤ s.size() ≤ 105
1 ≤ k ≤ 26
All characters are lowercase letters
*/

// Time complexity: O(n)
// Space complexity: O(1)

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniques {
    public static int longestSubstringWithKUniques(String s,int k){
        int n = s.length();
        int maxLen = -1,left = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int r = 0;r<n;r++){
            char ch = s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.size() > k){
                char leftChar = s.charAt(left);
                map.put(leftChar,map.get(leftChar)-1);
                if(map.get(leftChar) == 0){
                    map.remove(leftChar);
                }
                left++;
            }

            if(map.size() == k){
                maxLen = Math.max(maxLen, r-left+1);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        System.out.println(longestSubstringWithKUniques(s, k));
    }
}
