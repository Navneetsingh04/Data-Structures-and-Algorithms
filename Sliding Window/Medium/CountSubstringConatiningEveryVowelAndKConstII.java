/*
L.C: 3306. Count of Substrings Containing Every Vowel and K Consonants II

You are given a string word and a non-negative integer k.

Return the total number of substrings of word that contain every vowel ('a', 'e', 'i', 'o', and 'u') at least once and exactly k consonants.

Example 1:
Input: word = "aeioqq", k = 1
Output: 0
Explanation:
There is no substring with every vowel.

Example 2:
Input: word = "aeiou", k = 0
Output: 1
Explanation:
The only substring with every vowel and zero consonants is word[0..4], which is "aeiou".

Example 3:
Input: word = "ieaouqqieaouqq", k = 1
Output: 3
Explanation:
The substrings with every vowel and one consonant are:

word[0..5], which is "ieaouq".
word[6..11], which is "qieaou".
word[7..12], which is "ieaouq".
 
Constraints:
5 <= word.length <= 2 * 105
word consists only of lowercase English letters.
0 <= k <= word.length - 5 
*/

import java.util.HashMap;
import java.util.Map;

public class CountSubstringConatiningEveryVowelAndKConstII {
    public static  boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    
    public static long countOfSubstrings(String word, int k) {
        int n = word.length();
        Map<Character, Integer> mp = new HashMap<>(); 
        int[] nextCons = new int[n];
        int lastConsIdx = n;
        for (int i = n - 1; i >= 0; i--) {
            nextCons[i] = lastConsIdx;
            if (!isVowel(word.charAt(i))) {
                lastConsIdx = i;
            }
        }
        int i = 0, j = 0;
        long count = 0;
        int cons = 0;
        
        while(j < n){
            char ch = word.charAt(j);
            if (isVowel(ch)) {
                mp.put(ch, mp.getOrDefault(ch, 0) + 1);
            } 
            else {
                cons++;
            }
            
            while (cons > k) {
                char ci = word.charAt(i);
                if (isVowel(ci)) {
                    mp.put(ci, mp.get(ci) - 1);
                    if (mp.get(ci) == 0) {
                        mp.remove(ci);
                    }
                } 
                else {
                    cons--;
                }
                i++;
            }
            while(i < n && mp.size() == 5 && cons == k){
                int idx = nextCons[j];
                count += idx - j;
                char ci = word.charAt(i);
                if (isVowel(ci)) {
                    mp.put(ci, mp.get(ci) - 1);
                    if (mp.get(ci) == 0) {
                        mp.remove(ci);
                    }
                }
                else {
                    cons--;
                }
                i++;
            }
            j++;
        }
        return count;
    }
    public static void main(String[] args) {
        String word = "ieaouqqieaou";
        int k = 1;
        System.out.println(countOfSubstrings(word, k));
    }
}
