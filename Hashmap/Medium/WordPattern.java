/*
L.C:  290. Word Pattern

Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:

Each letter in pattern maps to exactly one unique word in s.
Each unique word in s maps to exactly one letter in pattern.
No two letters map to the same word, and no two words map to the same letter.

Example 1:
Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Explanation:
The bijection can be established as:
'a' maps to "dog".
'b' maps to "cat".

Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false

Example 3:
Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false

Constraints:
1 <= pattern.length <= 300
pattern contains only lower-case English letters.
1 <= s.length <= 3000
s contains only lowercase English letters and spaces ' '.
s does not contain any leading or trailing spaces.
All the words in s are separated by a single space.
*/

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        char ch[] = pattern.toCharArray();
        String str[] = s.split(" ");
        int n = ch.length;
        int m = str.length;

        if(n != m) return false;

        Map<Character,String> map = new HashMap<>();

        for(int i = 0;i<m;i++){
            if(map.containsKey(ch[i])){
                if(!map.get(ch[i]).equals(str[i])){
                    return false;
                } 
            }
            else if(map.containsValue(str[i])){
                return false;
            }
            map.put(ch[i],str[i]);
        }
        return true;
    }
    public static void main(String[] args) {
        String pattern = "abba";
        String s ="dog cat cat dog";
        System.out.println(wordPattern(pattern, s));
    }
}
