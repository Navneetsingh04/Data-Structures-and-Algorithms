/*
L.C: 387. First Unique Character in a String

Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

Example 1:
Input: s = "leetcode"
Output: 0

Example 2:
Input: s = "loveleetcode"
Output: 2

Example 3:
Input: s = "aabb"
Output: -1
 
Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters.
*/

import java.util.ArrayDeque;
import java.util.Queue;

public class FirstUniqueCharacterString {
    public static int firstUniqueChar(String str){
        Queue<Character> q = new ArrayDeque<>();
        int freq[] = new int[26];
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            freq[ch-'a']++;
            q.add(ch);

            while(!q.isEmpty()){
                char frontChar = q.peek();
                if(freq[frontChar-'a']>1){
                    q.poll();
                }
                else{
                    break;
                }
            } 
        }
        while (!q.isEmpty()) {
            char frontChar = q.poll();
            if (freq[frontChar - 'a'] == 1) {
                return str.indexOf(frontChar);
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String str = "loveleetcode";
        System.out.println("First non-repeating character At index: "+firstUniqueChar(str));
    }
}
