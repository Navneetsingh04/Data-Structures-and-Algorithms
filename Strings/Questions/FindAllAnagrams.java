/*
L.C: 438. Find All Anagrams in a String

Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:
Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 
Constraints:
1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.
*/
import java.util.ArrayList;
import java.util.List;
public class FindAllAnagrams {

    // 1st Approach : using hashMap;

//     public static List<Integer> findAnagrams(String s, String p) {
//         List<Integer> ans = new ArrayList<>();
//         if (s.length() < p.length()) return ans;
//         HashMap<Character, Integer> pMap = new HashMap<>();
//         for (char ch : p.toCharArray()) {
//             pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
//         }
//         HashMap<Character, Integer> sMap = new HashMap<>();
//         int left = 0;
//         for (int right = 0; right < s.length(); right++) {
//             char ch = s.charAt(right);
//             sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);

//             // If the window size matches compare maps
//             if (right - left + 1 == p.length()) {
//                 if (sMap.equals(pMap)) {
//                     ans.add(left);
//                 }
//                 // Slide the window to the right by removing the leftmost character
//                 char leftChar = s.charAt(left);
//                 sMap.put(leftChar, sMap.get(leftChar) - 1);
//                 if (sMap.get(leftChar) == 0) {
//                     sMap.remove(leftChar);
//                 }
//                 left++;
//             }
//         }
//         return ans;
//     }

// 2nd Approach

public static boolean matches(int smap[],int pmap[]){
    for(int i = 0;i<smap.length;i++){
        if(smap[i] != pmap[i]){
            return false;
        }
    }
    return true;
}
public static List<Integer> findAnagrams(String s, String p) {
    List<Integer> ans = new ArrayList<>();
    if(s.length() < p.length()) return ans;
    int pmap[] = new int[26];
    int smap[] = new int[26];

    for(char ch : p.toCharArray()){
        pmap[ch -'a']++;
    }
    for(int i = 0;i<p.length();i++){
        smap[s.charAt(i)-'a']++;
    }
    if(matches(smap,pmap)){
        ans.add(0);
    }
    for(int i = p.length();i<s.length();i++){
        smap[s.charAt(i)-'a']++;
        smap[s.charAt(i-p.length())- 'a']--;
        if(matches(smap,pmap)){
            ans.add(i-p.length()+1);
        }
    }
     return ans;
}
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> ans = findAnagrams(s, p);
        System.out.println(ans);
    }
}